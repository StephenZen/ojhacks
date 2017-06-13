package leetcode;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]

 Given target = 3, return true.
 */

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows == 0)
			return false;
		int cols = matrix[0].length;
		if (cols == 0)
			return false;

		return searchAux(matrix, 0, rows - 1, target);

	}

	boolean searchAux(int[][] matrix, int s, int e, int target) {
		int cols = matrix[0].length;

		int mid = (s + e) / 2;
		if (mid - 1 < s) {
			if (s == e)
				return searchRow(matrix[s], 0, cols - 1, target);
			else if (target > matrix[s][cols - 1]) {
				return searchRow(matrix[e], 0, cols - 1, target);
			} else
				return searchRow(matrix[s], 0, cols - 1, target);
		} else {
			if (target > matrix[mid][cols - 1]) {
				return searchAux(matrix, mid + 1, e, target);
			} else if (target < matrix[mid][0]) {
				return searchAux(matrix, s, mid - 1, target);
			} else
				return searchRow(matrix[mid], 0, cols - 1, target);
		}
	}

	boolean searchRow(int[] A, int s, int e, int target) {
		int mid = (s + e) / 2;
		if (mid - 1 < s) {
			if (A[s] == target)
				return true;
			else if (A[e] == target)
				return true;
			else
				return false;
		} else {
			if (A[mid] == target)
				return true;
			else if (A[mid] > target)
				return searchRow(A, s, mid - 1, target);
			else
				return searchRow(A, mid + 1, e, target);
		}
	}
}
