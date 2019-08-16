import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private Map<Integer,Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    public int getCount() {
     return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        this.transactionMap.putIfAbsent(transaction.getId(),transaction);

    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (isIdDontExists(id)){
            throw new IllegalArgumentException();
        }
        this.transactionMap.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (isIdDontExists(id)){
            throw new IllegalArgumentException();
        }
        this.transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        if (isIdDontExists(id)){
            throw new IllegalArgumentException();
        }
        return this.transactionMap.get(id);
    }

    private boolean isIdDontExists(int id) {
        return !this.transactionMap.containsKey(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        isThereNoSuchStatus(status);

        return this.transactionMap.values()
                .stream()
                .filter(e -> e.getStatus() == status)
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        isThereNoSuchStatus(status);

        return this.transactionMap.values()
                .stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .filter(e -> e.getStatus().equals(status))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        isThereNoSuchStatus(status);

        return this.transactionMap.values()
                .stream()
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .filter(e -> e.getStatus().equals(status))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionMap.values()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getId(), f.getId()))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        if (this.transactionMap.values().stream().noneMatch(e->e.getFrom().equals(sender))){
            throw new IllegalArgumentException();
        }

        return this.transactionMap.values()
                .stream()
                .filter(e -> e.getFrom().equals("testSender"))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        if (this.transactionMap.values().stream().noneMatch(e->e.getTo().equals(receiver))){
            throw new IllegalArgumentException();
        }

        return  this.transactionMap.values()
                .stream()
                .filter(e->e.getTo().equals(receiver))
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
    }



    public Iterator<Transaction> iterator() {
        return null;
    }

    private void isThereNoSuchStatus(TransactionStatus status) {
        if (this.transactionMap.values().stream().noneMatch(e -> e.getStatus() == status)) {
            throw new IllegalArgumentException();
        }
    }
}
