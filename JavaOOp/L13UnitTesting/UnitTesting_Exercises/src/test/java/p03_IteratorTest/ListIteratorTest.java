package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String[] INITIAL_INPUT = new String[]{
            "A",
            "B"
    };
    private ListIterator listIterator;

    @Before
    public void createListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(INITIAL_INPUT);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void ifThereIsNullPassedToTheConstructorShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void moveCommandShouldMoveTheInternalIndexToTheNextIndex() {
        this.listIterator.move();
        Assert.assertEquals(INITIAL_INPUT[1], this.listIterator.print());
    }

    @Test
    public void moveShouldReturnTrueIfItSuccessfullyMovedIndex() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseIfThereIsNoNextIndex() {
        for (String s : INITIAL_INPUT) {
            this.listIterator.move();
        }
        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereIsANextIndex() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnFlaseIfTheIndexIsOnTheLastElement() {
        for (String s : INITIAL_INPUT) {
            this.listIterator.move();
        }
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void printShouldPrintTheElementAtTheCurrentInternalIndex() {
        Assert.assertEquals(this.listIterator.print(), INITIAL_INPUT[0]);
    }

    @Test()
    public void callingPrintOnAEmptyCollectionShouldThrowAnExceptionWithTheMessageInvalidOperation() throws OperationNotSupportedException {
        String messageException = "";
        try {
            ListIterator listIteratorEmpty = new ListIterator(new String[0]);
            listIteratorEmpty.print();
        } catch (IllegalStateException str) {
            messageException = str.getMessage();
        }

        Assert.assertEquals("Invalid Operation!", messageException);
    }

    @Test(expected = IllegalStateException.class)
    public void callingPrintOnAEmptyCollectionShouldThrowIllegalStateExceptionClass() throws OperationNotSupportedException {


        ListIterator listIteratorEmpty = new ListIterator(new String[0]);
        listIteratorEmpty.print();

    }


}