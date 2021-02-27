package com.zsp1987.leetcode.uncategory;

/*
 Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

public class NumberOf1Bits {
	public int hammingWeight(int n) {
		int ret = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			int temp = mask & n;
			if (temp == 1)
				ret++;
			n = n >>> 1;
		}
		return ret;
	}
}

// 简�?�的�?�?作 �?次无符�?�左移 跟 1�?�与�?算 判断结果是�?�是1