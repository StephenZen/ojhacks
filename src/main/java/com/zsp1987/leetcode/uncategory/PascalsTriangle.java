package com.zsp1987.leetcode.uncategory;

/*
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return results;
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		results.add(row1);
		if (numRows == 1)
			return results;
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(1);
		row2.add(1);
		results.add(row2);
		if (numRows == 1)
			return results;
		generateAux(results, row2, 2, numRows);
		return results;
	}

	void generateAux(List<List<Integer>> results, List<Integer> result,
			int lvl, int numRows) {
		List<Integer> resultN = new ArrayList<Integer>();
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
		if (lvl == numRows)
			return;
		results.add(resultN);
		generateAux(results, resultN, lvl + 1, numRows);
	}
}

// 0,1,2 直接输出, 然�?��?层递归加上�?�的层