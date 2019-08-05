package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void createCustomLinkedList(){
        this.customLinkedList = new CustomLinkedList<>();
        this.customLinkedList.add(1);
        this.customLinkedList.add(2);
    }

    @Test
    public void getShouldWorkCorrect() {
        int temp = this.customLinkedList.get(0);

        Assert.assertEquals(1,temp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionWhenAnInvalidIndexIsEnter() {
        int temp = this.customLinkedList.get(2);

    }

    @Test
    public void setShouldWorkCorrect() {
        this.customLinkedList.set(1,5);
        int temp =this.customLinkedList.get(1);
        Assert.assertEquals(5,temp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionWhenAnInvalidIndexIsSpecified() {
        this.customLinkedList.set(2,5);

    }

    @Test
    public void addShouldWorkCorrect() {
        this.customLinkedList.add(3);
        Assert.assertTrue(this.customLinkedList.contains(3));
    }

    @Test
    public void removeAt() {
        int returnValue = this.customLinkedList.removeAt(1);
        Assert.assertEquals(2,returnValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtShouldThrowExceptionWhenAnInvalidIndexIsSpecified() {
        int returnValue = this.customLinkedList.removeAt(2);
    }

    @Test
    public void removeShouldReturnIndexOfTheParam() {
        Assert.assertEquals(0,this.customLinkedList.remove(1));
    }
    @Test
    public void removeShouldReturnMinusOneWhenDidntContainTheValue() {
        Assert.assertEquals(-1,this.customLinkedList.remove(11));
    }

    @Test
    public void indexOfReturnTheIndexOfTheFirstOccurrenceOfTheElement() {
        this.customLinkedList.add(1);
        this.customLinkedList.add(1);

        Assert.assertEquals(0,this.customLinkedList.indexOf(1));
    }
    @Test
    public void indexOfReturnMinusWhenDidntContainTheValue() {
        this.customLinkedList.remove(1);

        Assert.assertEquals(-1,this.customLinkedList.indexOf(1));
    }

    @Test
    public void containsShouldReturnTrueIfTheElementExists() {
        Assert.assertTrue(this.customLinkedList.contains(2));
    }
    @Test
    public void containsShouldReturnFalseIfTheElementDidntExists() {
        Assert.assertFalse(this.customLinkedList.contains(11));
    }

}