package leetcode;

/*
 Implement int sqrt(int x).

 Compute and return the square root of x.
 */

public class Sqrtx {
	int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int l = 1, r = x, ret = 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (m == x / m) {
				return m;
			} else if (m > x / m) {
				r = m - 1;
			} else {
				l = m + 1;
				ret = m;
			}
		}
		return ret;
	}
}

// 二分查找 挨个试出来