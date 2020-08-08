package com.zsp1987.leetcode;

/*
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int count5 = 0;
		int a = n;
		while (a > 0) {
			a = a / 5;
			count5 += a;
		}
		return count5;

	}
}

// 因为0是因为5 * 2 构�? 2在N!里�?对够用, 所以�?��?计算 5的数�?
// 而 n / 5 就等于当�? n出现�?于5的最高阶乘的数�? 比如(226 中有一个225(5^3))
// 所以此方法能统计出所有基数5的出现次数