package com.zsp1987.leetcode;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0 
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0 
 * Return 4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        
        int[][] res = new int[n][m];
        int max = 0;
        for(int i = 0 ; i < n; i++){
            if(matrix[i][0] == '0') res[i][0] = 0;
            else {
                res[i][0] = 1;
                max = 1;
                
            }
        }
        for(int j = 0; j< m; j++){
            if(matrix[0][j] == '0') res[0][j] = 0;
            else {
                res[0][j] = 1;
                max = 1;
            }
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j< m; j++){
                if(matrix[i][j] == '0') res[i][j] = 0;
                else{
                    int cur = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1])) + 1;
                    int temp = (int)Math.pow(cur, 2);
                    max = temp>max?temp:max;
                    res[i][j] = cur;
                }
            }
        }
        return max;
        
    }
}

// dp 