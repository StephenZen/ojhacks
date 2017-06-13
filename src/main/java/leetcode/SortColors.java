package leetcode;

/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem. 
 */

public class SortColors {
	public void sortColors(int[] A) {
		int n = A.length;
		int i = 0, j = 0, k = 0;
		for (int m = 0; m < n; m++) {

			if (A[m] == 0)
				i++;
			if (A[m] == 1)
				j++;
			if (A[m] == 2)
				k++;
		}
		int m = 0;
		while (m < n) {
			if (i > 0) {
				A[m] = 0;
				i--;
			} else if (j > 0) {
				A[m] = 1;
				j--;
			} else if (k > 0) {
				A[m] = 2;
				k--;
			}
			m++;
		}
	}
}

// 两个坐标分别维护颜色分界的边界 除了上面的重新生成 也可以用inspace swap
