package leetcode;

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

// 简单的位操作 每次无符号左移 跟 1做与运算 判断结果是否是1