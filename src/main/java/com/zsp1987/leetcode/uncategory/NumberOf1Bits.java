package com.zsp1987.leetcode.uncategory;

/*
 Write a function that takes an unsigned integer and returns the number of â€™1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer â€™11' has binary representation 00000000000000000000000000001011, so the function should return 3.
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

// ç®€å?•çš„ä½?æ“?ä½œ æ¯?æ¬¡æ— ç¬¦å?·å·¦ç§» è·Ÿ 1å?šä¸Žè¿?ç®— åˆ¤æ–­ç»“æžœæ˜¯å?¦æ˜¯1