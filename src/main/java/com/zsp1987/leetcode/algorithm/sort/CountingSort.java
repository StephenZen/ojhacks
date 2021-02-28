package com.zsp1987.leetcode.algorithm.sort;

import java.util.Arrays;

public class CountingSort {

	public static void countingSort(int[] a, int[] b, int[] c, int k) {

		for (int i = 0; i <= k; i++) {
			c[i] = 0;
		}

		for (int j = 0; j < a.length - 1; j++) {
			c[a[j]] = c[a[j]] + 1;
		}

		for (int i = 1; i <= k; i++) {
			c[i] = c[i] + c[i - 1];
		}

		for (int j = a.length - 1; j >= 0; j--) {
			b[c[a[j]]] = a[j];
			c[a[j]] = c[a[j]] - 1;
		}

	}

	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 0, 2, 3, 0, 3 };
		int[] b = new int[8];
		int[] c = new int[6];

		countingSort(a, b, c, 5);
		System.out.println(Arrays.toString(b));
	}
}
