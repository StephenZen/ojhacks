package com.zsp1987.leetcode.uncategory;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).
*/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;

            }
        }
    }
}

// 旋转一�?�就够 注�?边界
