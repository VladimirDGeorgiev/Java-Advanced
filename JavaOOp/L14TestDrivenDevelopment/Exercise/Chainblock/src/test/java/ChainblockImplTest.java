import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;


public class ChainblockImplTest {
    private static final Transaction TRANSACTION_ONE =
            new TransactionImpl(99999, TransactionStatus.FAILED, "testtest", "test1test1", 999999999);
    private Chainblock chainblock;

    @Before
    public void unit() {
        this.chainblock = new ChainblockImpl();
    }

    //add

    @Test
    public void addShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(1);
        Assert.assertTrue(this.chainblock.contains(transactionList.get(0)));
    }

    @Test
    public void addShouldWorkCorrectWithMoreElements() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        Assert.assertTrue(this.chainblock.contains(transactionList.get(0)));
    }

    //contain

    @Test
    public void containByTransactionShouldReturnFalseIfNoSuchElement() {
        Assert.assertFalse(this.chainblock.contains(TRANSACTION_ONE));
    }

    @Test
    public void containByIdShouldReturnFalseIfNoSuchElement() {
        Assert.assertFalse(this.chainblock.contains(TRANSACTION_ONE.getId()));
    }

    @Test
    public void containByIdShouldReturnTrueIfSuchElementExists() {
        this.chainblock.add(TRANSACTION_ONE);
        Assert.assertTrue(this.chainblock.contains(TRANSACTION_ONE.getId()));
    }

    //getCount

    @Test
    public void getCountShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        Assert.assertEquals(10, this.chainblock.getCount());
    }

    @Test
    public void getCountShouldWorkCorrectWithZeroElement() {
        Assert.assertEquals(0, this.chainblock.getCount());
    }

    //changeTransactionStatus(id, status)

    @Test
    public void changeTransactionStatusShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Assert.assertEquals(TransactionStatus.ABORTED, this.chainblock.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionIfNoSuchIdExists() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.changeTransactionStatus(9999, TransactionStatus.ABORTED);

    }

    //getById(id)

    @Test
    public void getByidShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        Assert.assertEquals(transactionList.get(0), this.chainblock.getById(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByidShouldThrowExcetionIfSuchTransactionDoesntExist() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getById(9999);
    }

    //removeTransactionById(id)

    @Test
    public void removeTransactionByIdShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        Assert.assertTrue(this.chainblock.contains(1));
        this.chainblock.removeTransactionById(1);
        Assert.assertFalse(this.chainblock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowExcetionIfSuchTransactionDoesntExist() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);

        this.chainblock.removeTransactionById(9999);

    }

    //getByTransactionStatus(status)

    @Test
    public void getByTransactionStatusShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);

        transactionList.remove(1);
        transactionList.remove(2);
        Transaction[] expected = transactionList
                .stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .toArray(Transaction[]::new);

        this.chainblock.changeTransactionStatus(2, TransactionStatus.ABORTED);
        this.chainblock.changeTransactionStatus(4, TransactionStatus.ABORTED);
        Iterable<Transaction> returnValue = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Transaction[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(Transaction[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExcetionIfSuchTransactionDoesntExist() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    }

    //getAllSendersWithTransactionStatus(status)

    @Test
    public void getAllSendersWithTransactionStatusShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);

        String[] expected = transactionList
                .stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .map(Transaction::getFrom)
                .toArray(String[]::new);

        Iterable<String> returnValue = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        String[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(String[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowExceptionIfNoSuchTransactionExists() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    //getAllReceiversWithTransactionStatus(status)

    @Test
    public void getAllReceiversWithTransactionStatusStatusShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);

        String[] expected = transactionList
                .stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .map(Transaction::getTo)
                .toArray(String[]::new);

        Iterable<String> returnValue = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        String[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(String[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowExceptionIfNoSuchTransactionExists() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

//getAllOrderedByAmountDescendingThenById()


    @Test
    public void getAllOrderedByAmountDescendingThenByIdStatusStatusShouldWorkCorrect() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);

        Transaction[] expected = transactionList
                .stream()
                .sorted((f, s) -> Integer.compare(s.getId(), f.getId()))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .toArray(Transaction[]::new);

        Iterable<Transaction> returnValue = this.chainblock.getAllOrderedByAmountDescendingThenById();
        Transaction[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(Transaction[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdStatusStatusShouldWorkCorrectWithEmptyCollection() {
        Transaction[] expected = new Transaction[0];

        Iterable<Transaction> returnValue = this.chainblock.getAllOrderedByAmountDescendingThenById();
        Transaction[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(Transaction[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    //getBySenderOrderedByAmountDescending(sender)

    @Test
    public void getBySenderOrderedByAmountDescendingShouldWorkCorrect() {
        List<Transaction> transactionList = createTransaction(10);
        transactionList.get(0).setFrom("testSender");
        transactionList.get(1).setFrom("testSender");
        transactionList.get(2).setFrom("testSender");
        transactionList.forEach(e->this.chainblock.add(e));


        Transaction[] expected = transactionList
                .stream()
                .filter(e->e.getFrom().equals("testSender"))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .toArray(Transaction[]::new);

        Iterable<Transaction> returnValue = this.chainblock.getBySenderOrderedByAmountDescending("testSender");
        Transaction[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(Transaction[]::new);

        Assert.assertArrayEquals(expected, actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowExceptionIfNoSuchSenderExists() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getBySenderOrderedByAmountDescending("test");
    }

    //getByReceiverOrderedByAmountThenById(receiver)

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldWorkCorrect() {
        List<Transaction> transactionList = createTransaction(10);
        transactionList.get(3).setTo("testReceiver");
        transactionList.get(1).setTo("testReceiver");
        transactionList.get(7).setTo("testReceiver");
        transactionList.forEach(e->this.chainblock.add(e));


        Transaction[] expected = transactionList
                .stream()
                .filter(e->e.getTo().equals("testReceiver"))
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .toArray(Transaction[]::new);

        Iterable<Transaction> returnValue = this.chainblock.getByReceiverOrderedByAmountThenById("testReceiver");
        Transaction[] actual = StreamSupport.stream(returnValue.spliterator(), false).toArray(Transaction[]::new);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowExceptionIfNoSuchReceiverExists() {
        List<Transaction> transactionList = createTransactionAndAddItToChainblock(10);
        this.chainblock.getByReceiverOrderedByAmountThenById("test");
    }



    private List<Transaction> createTransactionAndAddItToChainblock(int count) {
        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Transaction transaction = new TransactionImpl(i, TransactionStatus.SUCCESSFUL, "from" + i, "to" + i, 1 + i);
            transactionList.add(transaction);
            this.chainblock.add(transaction);
        }
        return transactionList;
    }

    private List<Transaction> createTransaction(int count) {
        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Transaction transaction = new TransactionImpl(i, TransactionStatus.SUCCESSFUL, "from" + i, "to" + i, 1 + i);
            transactionList.add(transaction);
        }
        return transactionList;
    }

}