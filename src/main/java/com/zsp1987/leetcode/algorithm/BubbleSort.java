package com.zsp1987.leetcode.algorithm;

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
}
