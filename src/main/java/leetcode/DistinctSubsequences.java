package leetcode;

/*
 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3. 
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int n = S.length();
		int m = T.length();
		if (n < m)
			return 0;
		int[][] result = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			result[i][0] = 1;
		}

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				if (S.charAt(r - 1) == T.charAt(c - 1)) {
					result[r][c] = result[r - 1][c] + result[r - 1][c - 1];
				} else
					result[r][c] = result[r - 1][c];
			}
		}
		return result[n][m];
	}
}

// dp 每个格代表长度为r的S 变换到长度为c的T所用的步数, 若当前不等则为r-1的变换步数, 否为为[r-1][c] 和 [r-1][c-1]变化步数之和