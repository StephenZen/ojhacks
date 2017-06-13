package leetcode;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

/*
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 */

public class HappyNumber {

	public boolean isHappy(int n) {

		HashSet<Integer> set = new HashSet<Integer>();
		int i = n;
		while (!set.contains(i)) {
			set.add(i);
			int tmp = 0, m;
			while (i > 0) {
				m = i % 10;
				tmp += m * m;
				i = i / 10;
			}
			if (tmp == 1)
				return true;

			i = tmp;
		}

		return false;

	}

	@Test
	public void TestIsHappy() {
		HappyNumber h = new HappyNumber();
		Assert.assertTrue(h.isHappy(1));
		Assert.assertTrue(h.isHappy(19));
		Assert.assertTrue(h.isHappy(7));
	}
}

// 用hashset储存结果
// 按照每位的数字的平方 加出来个结果, 如果set里有重复 就说明有循环 return false
// 如果加和等于1 立即返回