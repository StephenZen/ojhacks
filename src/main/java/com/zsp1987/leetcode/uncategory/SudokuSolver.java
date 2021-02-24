package com.zsp1987.leetcode.uncategory;

/*
 Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution. 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SudokuSolver {
	public static void main(String[] args) {

		SudokuSolver s = new SudokuSolver();
		char[][] board = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		s.solveSudoku(board);

		for (int i = 0; i < 9; i++) {
			System.out.print("{");
			for (int j = 0; j < 9; j++) {

				System.out.print(board[i][j]);
				System.out.print(",");
			}
			System.out.print("}");
			System.out.println();
			
		}

	}

	class BlankSpot {
		int i;
		int j;

		public BlankSpot(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	List<HashSet<Integer>> verticalSets = new ArrayList<HashSet<Integer>>(9);
	List<HashSet<Integer>> horizontalSets = new ArrayList<HashSet<Integer>>(9);
	List<HashSet<Integer>> squareSets = new ArrayList<HashSet<Integer>>(9);
	boolean finish = false;

	public void solveSudoku(char[][] board) {

		if (board == null)
			return;
		int n = board.length;
		if (n != 9)
			return;
		int m = board[0].length;
		if (m != 9)
			return;

		initSets();
		ArrayList<BlankSpot> candidates = new ArrayList<BlankSpot>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int val = board[i][j] - '0';
				if (val >= 1 && val <= 9) {
					insertVertical(val, i, j);
					insertHorizontal(val, i, j);
					insertSquare(val, i, j);
				} else {
					candidates.add(new BlankSpot(i, j));
				}
			}
		}

		int size = candidates.size();
		if (size == 0)
			return;
		else {
			buildSudoku(board, candidates, 0, size);
		}
	}

	void buildSudoku(char[][] board, ArrayList<BlankSpot> candidates, int lvl,
			int size) {
		if (finish)
			return;
		if (lvl == size) {
			finish = true;
			return;
		} else {
			BlankSpot curBs = candidates.get(lvl);
			int i = curBs.i;
			int j = curBs.j;
			for (int val = 1; val <= 9; val++) {
				if (checkVertial(val, i, j) && checkHorizontal(val, i, j)
						&& checkSquere(val, i, j)) {
					insertVertical(val, i, j);
					insertHorizontal(val, i, j);
					insertSquare(val, i, j);
					board[i][j] = (char) (val + '0');
					buildSudoku(board, candidates, lvl + 1, size);
					if (!finish) {
						removeVertical(val, i, j);
						removeHorizontal(val, i, j);
						removeSquare(val, i, j);
						board[i][j] = '.';
					} else {
						return;
					}
				}
			}

		}
	}

	void initSets() {
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> vertical = new HashSet<Integer>();
			verticalSets.add(vertical);
			HashSet<Integer> horizontal = new HashSet<Integer>();
			horizontalSets.add(horizontal);
			HashSet<Integer> square = new HashSet<Integer>();
			squareSets.add(square);
		}
	}

	void insertVertical(int val, int i, int j) {
		int verticalIndex = j;
		HashSet<Integer> set = verticalSets.get(verticalIndex);
		set.add(val);
		verticalSets.set(verticalIndex, set);
	};

	void insertHorizontal(int val, int i, int j) {
		int horizontalIndex = i;
		HashSet<Integer> set = horizontalSets.get(horizontalIndex);
		set.add(val);
		horizontalSets.set(horizontalIndex, set);
	}

	void insertSquare(int val, int i, int j) {
		int squareIndex = (i / 3) * 3 + (j / 3);
		HashSet<Integer> set = squareSets.get(squareIndex);
		set.add(val);
		squareSets.set(squareIndex, set);
	}

	void removeVertical(int val, int i, int j) {
		int verticalIndex = j;
		HashSet<Integer> set = verticalSets.get(verticalIndex);
		set.remove(val);
		verticalSets.set(verticalIndex, set);

	}

	void removeHorizontal(int val, int i, int j) {
		int horizontalIndex = i;
		HashSet<Integer> set = horizontalSets.get(horizontalIndex);
		set.remove(val);
		horizontalSets.set(horizontalIndex, set);
	}

	void removeSquare(int val, int i, int j) {
		int squareIndex = (i / 3) * 3 + (j / 3);
		HashSet<Integer> set = squareSets.get(squareIndex);
		set.remove(val);
		squareSets.set(squareIndex, set);
	}

	boolean checkVertial(int val, int i, int j) {
		int verticalIndex = j;
		HashSet<Integer> set = verticalSets.get(verticalIndex);
		if (!set.contains(val))
			return true;
		else
			return false;

	}

	boolean checkHorizontal(int val, int i, int j) {
		int horizontalIndex = i;
		HashSet<Integer> set = horizontalSets.get(horizontalIndex);
		if (!set.contains(val))
			return true;
		else
			return false;

	}

	boolean checkSquere(int val, int i, int j) {
		int squareIndex = (i / 3) * 3 + (j / 3);
		HashSet<Integer> set = squareSets.get(squareIndex);
		if (!set.contains(val))
			return true;
		else
			return false;

	}

}