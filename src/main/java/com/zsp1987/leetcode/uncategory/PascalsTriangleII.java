package com.zsp1987.leetcode.uncategory;

/*
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space? 
 */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		if (rowIndex == 0)
			return result;
		result.add(1);
		if (rowIndex == 1)
			return result;
		int lvl = 2;
		while (lvl <= rowIndex) {
			ArrayList<Integer> resultN = new ArrayList<Integer>();
			resultN.add(1);
			int pre = 0;
			for (int i : result) {
				if (pre == 0)
					pre = i;
				else {
					resultN.add(pre + i);
					pre = i;
				}
			}
			resultN.add(1);
			result = resultN;
			lvl++;
		}
		return result;
	}
}

//�?层记录一个列表 为上层的列表, �?�计算当�?的列表