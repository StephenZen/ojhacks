package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

/*
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

public class GreyCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if (0 == n)
			return list;
		list.add(1);
		expand(1, n, list);
		return list;
	}

	void expand(int c, int n, List<Integer> list) {
		if (c == n)
			return;
		else {
			for (int i = list.size() - 1; i >= 0; i--) {
				int a = list.get(i);
				a = a | (1 << (c));
				list.add(a);
			}
			expand(c + 1, n, list);
		}
	}
}

// 回溯 就是�?次 最�?�?加个1