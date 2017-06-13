package leetcode;

/*
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */

public class WordSearch {

	boolean FOUND = false;

	public boolean exist(char[][] board, String word) {

		if (word == null || word.length() == 0)
			return true;
		int k = word.length();
		int n = board.length;
		if (n == 0)
			return false;
		int m = board[0].length;
		if (m == 0)
			return false;

		boolean result = false;
		Outter: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (word.charAt(0) == board[i][j]) {
					char[][] testBoard = board.clone();
					boolean currentresult = search(testBoard, word, i, j, 0, k,
							n, m);
					result |= currentresult;
					if (result == true) {
						break Outter;
					}
				}
			}
		}
		return result;

	}

	boolean search(char[][] board, String word, int x, int y, int lvl, int k,
			int n, int m) {
		if (FOUND) {
			return true;
		} else if (lvl == k) {
			FOUND = true;
			return true;
		} else if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		} else {
			if (board[x][y] == '.' || board[x][y] != word.charAt(lvl)) {
				return false;
			} else {
				board[x][y] = '.';

				if (search(board, word, x, y - 1, lvl + 1, k, n, m))
					return true;

				if (search(board, word, x, y + 1, lvl + 1, k, n, m))
					return true;

				if (search(board, word, x - 1, y, lvl + 1, k, n, m))
					return true;

				if (search(board, word, x + 1, y, lvl + 1, k, n, m))
					return true;

				board[x][y] = word.charAt(lvl);
				return false;

			}
		}
	}

}

// bt 一次查矩阵每个点是否是word开头 如果是就回溯查找 回溯上下左右查找 找到就标记flag 停止查找