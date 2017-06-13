package leetcode;

/*
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class NQueensII {
    int[] line;

    public int totalNQueens(int n) {
        line = new int[n];
        return placeQueen(0, n);
    }

    public int placeQueen(int i, int n) {
        if (i == n) {
            return 1;
        }

        int count = 0;

        for (int j = 0; j < n; j++) {
            if (isSafe(i, j)) {
                line[i] = j;
                count += placeQueen(i + 1, n);
                line[i] = 0;        //delete this line can also pass the oj, why?
            }
        }
        return count;
    }

    public boolean isSafe(int i, int j) {
        for (int preRow = 0; preRow < i; preRow++) {
            int preCol = line[preRow];
            if (preRow == i) {
                return false;
            }
            if (preCol == j) {
                return false;
            }
            if (i - preRow == j - preCol) {
                return false;
            }
            if (preRow + preCol == i + j) {
                return false;
            }
        }
        return true;
    }
}
