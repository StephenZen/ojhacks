package com.zsp1987.leetcode;

/*
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4. 
 */

public class BitwiseAndOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == n)
			return m;

		int ret = 0;
		for (int i = 30; i >= 0; i--) {
			if ((n >> i & 1) == 1) {
				if ((m >> i & 1) == 1)
					ret |= 1 << i;
				else
					return ret;
			}
		}

		return 0;
	}
}

// �?移�?算
// 如果两数相�?� 直接return
// �?�则中间必有间隔的0
// 一次�?移算出高�?1的连续性