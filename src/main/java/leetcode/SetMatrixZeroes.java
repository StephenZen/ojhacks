package leetcode;

/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.
 Follow up:

 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?

 */

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return;
		int m = matrix[0].length;
		if (m == 0)
			return;
		int[] rows = new int[n];
		int[] cols = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = 0;

				}
			}
		}

		for (int j = 0; j < m; j++) {
			if (cols[j] == 1) {
				for (int i = 0; i < n; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}