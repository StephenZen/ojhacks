package leetcode;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }

        return A.length + 1;
    }
	
	public int firstMissingPositiveOld(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		int k = partition(A);
		for (int i = 0; i < k; i++) {
			int cur = Math.abs(A[i]);
			if (cur < k + 1)
				A[cur - 1] = A[cur - 1] > 0 ? -A[cur - 1] : A[cur - 1];
		}
		for (int i = 0; i < k; i++) {
			if (A[i] > 0)
				return i + 1;
		}
		return k + 1;
	}

	int partition(int[] A) {
		int rIndex = A.length - 1;
		int i = 0;
		while (i <= rIndex) {
			int cur = A[i];
			if (cur <= 0) {
				swap(A, i, rIndex);
				rIndex--;
			} else {
				i++;
			}
		}
		return rIndex + 1;
	}

	void swap(int[] A, int l, int r) {
		int tmp = A[r];
		A[r] = A[l];
		A[l] = tmp;
	}
}

// 内部替换 扫一遍 如果所在index的内容 符合范围 与合适位置的值互换直到不符合范围
// 老思路 桶排序 先求出候选整数的最大范围 用正负标记桶是否被占 变成复数表示已经被统计过了