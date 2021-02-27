package com.zsp1987.leetcode.uncategory;

/*
 The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 -2 (K) 	-3 	3
 -5 	-10 	1
 10 	30 	-5 (P)

 Notes:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

 */

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {

		int n = dungeon.length;
		if (n == 0)
			return 0;
		int m = dungeon[0].length;
		if (m == 0)
			return 0;

		int[][] mini = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1)
				mini[i][m - 1] = dungeon[i][m - 1];
			else {
				mini[i][m - 1] = mini[i + 1][m - 1] + dungeon[i][m - 1];

			}
			if (mini[i][m - 1] > 0)
				mini[i][m - 1] = 0;
		}

		for (int j = m - 1; j >= 0; j--) {
			if (j == m - 1)
				mini[n - 1][j] = dungeon[n - 1][j];
			else {
				mini[n - 1][j] = mini[n - 1][j + 1] + dungeon[n - 1][j];

			}
			if (mini[n - 1][j] > 0)
				mini[n - 1][j] = 0;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				mini[i][j] = Math.max(mini[i + 1][j], mini[i][j + 1])
						+ dungeon[i][j];
				if (mini[i][j] > 0)
					mini[i][j] = 0;
			}
		}

		return Math.abs(mini[0][0]) + 1;

	}
}

// dp 从�?�下往左上算
// mini[i][j] = Math.max(mini[i + 1][j], mini[i][j + 1]) + dungeon[i][j]
// 如果当�?值>0, 直接�?�为0, 因为�?需�?多余的体力
