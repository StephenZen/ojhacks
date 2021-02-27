package com.zsp1987.leetcode.uncategory;

/*
 (Ref: Largest Rectangle In histogram)

 Given a 2D binary matrix filled with 0's and 1's, 
 find the largest rectangle containing all ones and return its area. 
 */

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null)
			return 0;
		int n = matrix.length;
		if (n == 0)
			return 0;
		int m = matrix[0].length;
		if (m == 0)
			return 0;

		// record histogram
		int[][] height = new int[n + 1][m];

		// for each row
		Stack<Integer> stack;
		int max = 0;

		for (int i = 0; i < n; i++) {
			stack = new Stack<Integer>();
			stack.push(-1);
			for (int j = 0; j < m; j++) {
				int curHeight;
				if (matrix[i][j] == '0')
					curHeight = 0;
				else
					curHeight = height[i][j] + 1;
				height[i + 1][j] = curHeight;

				while (stack.peek() > -1) {
					if (curHeight >= height[i + 1][stack.peek()]) {
						break;
					} else {
						int lastIndex = stack.pop();
						int area = height[i + 1][lastIndex]
								* (j - 1 - stack.peek());
						max = Math.max(max, area);
					}
				}
				stack.push(j);
			}
			while (stack.peek() > -1) {
				int lastIndex = stack.pop();
				int area = height[i + 1][lastIndex] * (m - 1 - stack.peek());
				max = Math.max(max, area);
			}

		}

		return max;
	}
}

// �?层计算�?层长方体的最大长度 �?层的height用到了dp
