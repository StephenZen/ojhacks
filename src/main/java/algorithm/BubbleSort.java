package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {

    public void bubbleSort(int[] num) {

        boolean switched;

        do {
            switched = false;
            for (int i = 0; i < num.length - 1; i++) {
                if (num[i + 1] < num[i]) {
                    int temp = num[i + 1];
                    num[i + 1] = num[i];
                    num[i] = temp;
                    switched = true;
                }
            }
        } while (switched);
    }

    @Test
    public void bubbleTest() {
        int[] input = {2, 1, 3};
        int[] output = {1, 2, 3};
        bubbleSort(input);
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(input[i], output[i]);
        }

    }
}
