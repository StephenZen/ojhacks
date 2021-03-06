package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.annotation.LeetCode;

@LeetCode(64)
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int minSum = 0;
		int m = grid.length;
		if (m == 0)
			return minSum;
		int n = grid[0].length;
		if (n == 0)
			return minSum;
		int[][] temp = new int[m][n];
		temp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			temp[i][0] = temp[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			temp[0][j] = temp[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				temp[i][j] = Math.min(temp[i - 1][j] + grid[i][j], temp[i][j - 1] + grid[i][j]);
			}
		}
		return temp[m - 1][n - 1];
	}
}
