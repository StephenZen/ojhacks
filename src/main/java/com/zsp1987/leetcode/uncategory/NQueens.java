package com.zsp1987.leetcode.uncategory;

/*
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 */

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NQueens {
  List<List<String>> results = new ArrayList<List<String>>();
  int[] line;

  public List<List<String>> solveNQueens(int n) {
    if (n == 0)
      return results;
    line = new int[n];
    build(0, n);
    return results;
  }

  void build(int lvl, int n) {
    if (lvl == n) {
      List<String> result = new ArrayList<String>();
      for (int i = 0; i < n; i++) {
        result.add(buildString(line[i], n));
      }
      results.add(result);

    } else {
      for (int j = 1; j <= n; j++) {
        if (isValid(lvl, j)) {
          line[lvl] = j;
          build(lvl + 1, n);
          line[lvl] = 0;
        }
      }
    }
  }

  boolean isValid(int lvl, int j) {
    for (int i = 0; i < lvl; i++) {

      // check vertical
      if (line[i] == j)
        return false;

      // check cross
      if (Math.abs(lvl - i) == Math.abs(line[i] - j))
        return false;
    }
    return true;
  }

  String buildString(int i, int n) {
    // convert int array to string
    int j = 0;
    StringBuilder sb = new StringBuilder();
    while (j < n) {
      if (j == i - 1) {
        sb.append('Q');
      } else {
        sb.append('.');
      }
      j++;
    }
    return sb.toString();
  }
}

class My8Queen {

  public void solve8Queen() {
    int[][] board = new int[8][8];
    backtrack(board, 0);
  }

  public void backtrack(int[][] board, int row) {
    if (row == board.length) {
      System.out.println("-----board-----");
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j] + ",");
        }
        System.out.println("");
      }
      System.out.println("------end------");
      return;
    }

    for (int col = 0; col < board[row].length; col++) {
      if (!isvalid(board, row, col)) {
        continue;
      }

      board[row][col] = 1;
      backtrack(board, row + 1);
      board[row][col] = 0;
    }
  }

  private boolean isvalid(int[][] board, int row, int col) {
    for (int r = row - 1; r >= 0; r--) {
      if (board[r][col] == 1) {
        return false;
      }
    }

    for (int c = col - 1, r = row - 1; c >= 0 && r >= 0; c--, r--) {
      if (board[r][c] == 1) {
        return false;
      }
    }

    for (int c = col + 1, r = row - 1; c <= board[row].length - 1 && r >= 0; c++, r--) {
      if (board[r][c] == 1) {
        return false;
      }
    }

    return true;
  }
}

class My8QueenTest {

  @Test
  public void test() {
    My8Queen my8Queen = new My8Queen();
    my8Queen.solve8Queen();
  }
}
