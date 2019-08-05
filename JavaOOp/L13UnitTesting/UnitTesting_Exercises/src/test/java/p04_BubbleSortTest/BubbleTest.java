package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class BubbleTest {
    private  int[] elements = new int[]{Integer.MAX_VALUE,75,60,5,1,0,-1,-10,Integer.MIN_VALUE};
    private  int[] sorted = Arrays.stream(elements).sorted().toArray();


    @Test
    public void bubbleSortShouldSortCorrect(){
        Bubble.sort(elements);
        Assert.assertArrayEquals(sorted,elements);
        System.out.println();
    }

}