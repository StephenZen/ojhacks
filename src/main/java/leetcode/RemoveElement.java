package leetcode;

/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 */

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int n = A.length;
		if (n == 0)
			return 0;
		else if (n == 1 & A[0] != elem)
			return 1;
		else if (n == 1 & A[0] == elem)
			return 0;
		else {
			int i = 0, j = n - 1;
			while (i <= j) {
				if (A[i] == elem) {
					exchange(A, i, j);
					j--;
				} else {
					i++;
				}
			}
			return i;
		}
	}

	void exchange(int A[], int a, int b) {
		int tmp = A[b];
		A[b] = A[a];
		A[a] = tmp;
	}
}

// 首尾交换夹出来