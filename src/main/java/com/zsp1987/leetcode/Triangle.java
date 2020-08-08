package com.zsp1987.leetcode;

/*
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> newList;
		for (List<Integer> curList : triangle) {
			int n = curList.size();
			newList = new ArrayList<Integer>();
			if (n == 1) {
				newList.add(curList.get(0));
			} else {
				List<Integer> lastList = result.get(n - 2);
				int first = lastList.get(0) + curList.get(0);
				newList.add(first);
				for (int i = 1; i < n - 1; i++) {
					int tmp = curList.get(i);
					int min = Math.min(lastList.get(i - 1), lastList.get(i));
					newList.add(tmp + min);
				}
				int last = lastList.get(n - 2) + curList.get(n - 1);
				newList.add(last);
			}
			result.add(newList);
		}

		List<Integer> lastList = result.get(result.size() - 1);
		int min = lastList.get(0);
		for (int i = 1; i < lastList.size(); i++) {
			min = min > lastList.get(i) ? lastList.get(i) : min;
		}

		return min;
	}
}

// 从上到下 计算�?个path的sum的和, 从最�?�一个的sum的arraylist中找出最�?的一个