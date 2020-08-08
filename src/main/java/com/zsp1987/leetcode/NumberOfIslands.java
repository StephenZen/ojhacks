package com.zsp1987.leetcode;

/*
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000

 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011

 Answer: 3
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int n = grid.length;
		if (n == 0)
			return 0;
		int m = grid[0].length;
		if (m == 0)
			return 0;
		int ret = 0;
		int[][] visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1' && visited[i][j] == 0) {
					ret++;
					dfs(grid, visited, i, j, n, m);
				}
			}
		}
		return ret;
	}

	void dfs(char[][] grid, int[][] visited, int i, int j, int n, int m) {
		if (visited[i][j] == 1)
			return;
		if (grid[i][j] == '1') {
			visited[i][j] = 1;
			if (i > 0)
				dfs(grid, visited, i - 1, j, n, m);
			if (i < n - 1)
				dfs(grid, visited, i + 1, j, n, m);
			if (j > 0)
				dfs(grid, visited, i, j - 1, n, m);
			if (j < m - 1)
				dfs(grid, visited, i, j + 1, n, m);
		}
	}
}

// 用一个visited的2d数组�?�记录是�?�visit过 �?��?�?�?
// 一旦当�?数是1 并且没有visited 按照左�?�上下的顺�?用dfs探寻