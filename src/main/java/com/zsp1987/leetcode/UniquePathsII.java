package com.zsp1987.leetcode;

/*
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }

        return paths[n - 1][m - 1];
    }

    public int uniquePathsWithObstaclesOld(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        if (m == 0) return 0;
        int[][] result = new int[n][m];
        if (obstacleGrid[0][0] == 1) return 0;
        if (m == 1 && n == 1) return 1;
        result[0][0] = 0;
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 1 || result[0][j - 1] == -1) result[0][j] = -1;
            else {
                result[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1 || result[i - 1][0] == -1) result[i][0] = -1;
            else {
                result[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) result[i][j] = -1;
                else {
                    if (result[i - 1][j] == -1 && result[i][j - 1] == -1) result[i][j] = -1;
                    else if (result[i - 1][j] == -1) result[i][j] = result[i][j - 1];
                    else if (result[i][j - 1] == -1) result[i][j] = result[i - 1][j];
                    else result[i][j] = result[i - 1][j] + result[i][j - 1];
                }

            }
        }
        return result[n - 1][m - 1] == -1 ? 0 : result[n - 1][m - 1];

    }
}

// 一样是dp �?��?过把�?能到的地方标记为-1 如果本格是障�?物 直接-1 , 
// 如果上格是障�?物 左格�?是 等于左格, �??之等于上格, 或上左之和
// �?章�??供的算法 �?��?�的�?用了array �?始化为0的特性
