package leetcode;

/*
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return true;
			if (A[start] < A[mid]) {
				if (target >= A[start] && target < A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (A[start] > A[mid]) {
				if (target > A[mid] && target <= A[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else
				start++;
		}
		return false;
	}
}

// 二分查找 比较中值和左值大小 确定单调递增区间