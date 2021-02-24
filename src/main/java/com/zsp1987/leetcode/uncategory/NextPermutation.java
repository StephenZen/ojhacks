package com.zsp1987.leetcode.uncategory;

/*
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 â†’ 1,3,2 3,2,1 â†’
 * 1,2,3 1,1,5 â†’ 1,5,1
 */

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n == 0 || n == 1)
			return;
		int index = n - 1;
		while (index > 0) {
			if (num[index] > num[index - 1]) {
				break;
			}
			index--;
		}
		if (index == 0) {
			reverse(num, 0, n - 1);
			return;
		} else {
			int left = index - 1;
			while (index < n && num[index] > num[left]) {
				index++;
			}
			int right = index - 1;
			exchange(num, left, right);
			reverse(num, left + 1, n - 1);
		}
	}

	void exchange(int[] num, int l, int r) {
		int tmp = num[r];
		num[r] = num[l];
		num[l] = tmp;
	}

	void reverse(int[] num, int i, int j) {
		while (i < j) {
			exchange(num, i, j);
			i++;
			j--;
		}

	}
}

// ä»å?³å¾€å·¦å¤„ç?† ç›´åˆ°é?‡åˆ°æ¯”å·¦ä½?å¤§å?œæ­¢, è®°å½•æ­¤å·¦ä½? 
// è‹¥ä¸€ç›´æœªå?œ, å??è½¬æ•´ä¸ªæ•°ç»„
// å?¦åˆ™åœ¨å?‘å?³æ‰«, çŸ¥é?“ç¢°åˆ°æ¯”å·¦ä½?å°?çš„å?œæ­¢, è®°å½•æ­¤å?³ä½?
// å°†è¿™æ®µåŒºåŸŸå??è½¬