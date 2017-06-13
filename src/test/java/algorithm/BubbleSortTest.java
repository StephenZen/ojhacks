package algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Shaopeng Zhang on 6/13/2017.
 */
public class BubbleSortTest {
    @Test
    public void bubbleTest() {
        BubbleSort algo = new BubbleSort();
        int[] input = {2, 1, 3};
        int[] output = {1, 2, 3};
        algo.bubbleSort(input);
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(input[i], output[i]);
        }

    }
}
