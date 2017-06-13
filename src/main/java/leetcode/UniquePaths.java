package leetcode;

/*
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (n < 1 || m < 1)
			return 0;
		int[][] steps = new int[m][n];
		for (int i = 0; i < m; i++) {
			steps[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			steps[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
			}
		}
		return steps[m - 1][n - 1];
	}
}

// 动态编程 所在格等于 上格和左格的方法之和