package leetcode;

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

// 因为0是因为5 * 2 构成 2在N!里绝对够用, 所以只要计算 5的数量
// 而 n / 5 就等于当前 n出现小于5的最高阶乘的数量 比如(226 中有一个225(5^3))
// 所以此方法能统计出所有基数5的出现次数