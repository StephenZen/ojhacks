package leetcode;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 */
public class JumpGameII {
	public int jump(int[] A) {
		if (A == null)
			return 0;
		int n = A.length;
		if (n <= 1)
			return 0;
		int[] result = new int[n];
		int max = 0;
		int lastmax = 0;
		for (int cur = 0; cur < n; cur++) {
			if (cur + A[cur] >= n - 1)
				return result[lastmax] + 1;
			if (cur + A[cur] > max) {
				max = cur + A[cur];
			}
			if (cur + A[cur] > lastmax) {
				result[cur + A[cur]] = result[lastmax] + 1;
			} else {
				result[cur + A[cur]] = result[lastmax];
			}
			if (cur == lastmax)
				lastmax = max;
		}

		return result[n - 1];
	}
}

// 贪心 步步推进