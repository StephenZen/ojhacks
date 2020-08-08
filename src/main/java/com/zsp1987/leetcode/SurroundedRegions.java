package com.zsp1987.leetcode;

import java.util.LinkedList;

/*

 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 */
public class SurroundedRegions {

	class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public void solve(char[][] board) {

		if (board == null)
			return;

		int n = board.length;
		if (n < 3)
			return;
		int m = board[0].length;
		if (m < 3)
			return;

		boolean[][] visited = new boolean[n][m];

		for (int col = 0; col < m; col++) {
			if (board[0][col] == 'O')
				exploreBoard(board, visited, 0, col);
		}
		for (int col = 0; col < m; col++) {
			if (board[n - 1][col] == 'O')
				exploreBoard(board, visited, n - 1, col);
		}
		for (int row = 0; row < n; row++) {
			if (board[row][0] == 'O')
				exploreBoard(board, visited, row, 0);
		}
		for (int row = 0; row < n; row++) {
			if (board[row][m - 1] == 'O')
				exploreBoard(board, visited, row, m - 1);
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (visited[row][col] == false && board[row][col] == 'O') {
					board[row][col] = 'X';
				}
			}
		}
	}

	void exploreBoard(char[][] board, boolean[][] visited, int row, int col) {

		LinkedList<Point> queue = new LinkedList<Point>();
		queue.addLast(new Point(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Point p = queue.removeFirst();
			// up
			if (p.row != 0 && board[p.row - 1][p.col] == 'O'
					&& !visited[p.row - 1][p.col]) {
				queue.addLast(new Point(p.row - 1, p.col));
				visited[p.row - 1][p.col] = true;
			}
			// left
			if (p.col != 0 && board[p.row][p.col - 1] == 'O'
					&& !visited[p.row][p.col - 1]) {
				queue.addLast(new Point(p.row, p.col - 1));
				visited[p.row][p.col - 1] = true;
			}
			// down
			if (p.row != board.length - 1 && board[p.row + 1][p.col] == 'O'
					&& !visited[p.row + 1][p.col]) {
				queue.addLast(new Point(p.row + 1, p.col));
				visited[p.row + 1][p.col] = true;
			}
			// right
			if (p.col != board[0].length - 1 && board[p.row][p.col + 1] == 'O'
					&& !visited[p.row][p.col + 1]) {
				queue.addLast(new Point(p.row, p.col + 1));
				visited[p.row][p.col + 1] = true;

			}
		}
	}
}

// å?ªæœ‰å››ä¸ªè¾¹ä¸Šçš„Oæ‰?ä¸?èƒ½è¢«å›´ä½?, ä»Žå¥¹ä»¬å‡ºå?‘,ä¸Šä¸‹å·¦å?³æŽ¢ç´¢O, æœ€å?ŽæŠŠæ²¡æœ‰æŽ¢ç´¢åˆ°Oå…¨éƒ¨å?˜æˆ?X