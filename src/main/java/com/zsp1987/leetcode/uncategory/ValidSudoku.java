package com.zsp1987.leetcode.uncategory;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 */

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		if (n != 9)
			return false;
		int m = board[0].length;
		if (m != 9)
			return false;
		return (checkHorizontal(board) && checkVertical(board) && checkSquare(board));
	}

	boolean checkHorizontal(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] result = new int[9];
			for (int j = 0; j < 9; j++) {
				int temp = (int) board[i][j] - '0';
				if (temp == -2)
					continue; // for '.'
				else if (temp > 9 || temp < 1)
					return false;
				else {
					if (result[temp - 1] == 0)
						result[temp - 1] = 1;
					else
						return false;
				}
			}
		}
		return true;
	}

	boolean checkVertical(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] result = new int[9];
			for (int j = 0; j < 9; j++) {
				int temp = (int) board[j][i] - '0';
				if (temp == -2)
					continue; // for '.'
				else if (temp > 9 || temp < 1)
					return false;
				else {
					if (result[temp - 1] == 0)
						result[temp - 1] = 1;
					else
						return false;
				}
			}
		}
		return true;
	}

	boolean checkSquare(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[] result = new int[9];
				for (int n = i * 3; n < (i + 1) * 3; n++) {
					for (int m = j * 3; m < (j + 1) * 3; m++) {
						int temp = (int) board[n][m] - '0';
						if (temp == -2)
							continue; // for '.'
						else if (temp > 9 || temp < 1)
							return false;
						else {
							if (result[temp - 1] == 0)
								result[temp - 1] = 1;
							else
								return false;
						}
					}
				}
			}
		}
		return true;
	}
}

// 用数组存临时结果