package leetcode;

/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2. 
 */

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("30"));
	}

	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;

		int n = s.length();
		int[] ret = new int[n + 1];

		if (s.charAt(0) == '0')
			ret[1] = 0;
		else
			ret[1] = 1;
		
		if(n==1) return ret[1];
		
		
		if (ret[1] == 0)
			ret[2] = 0;
		else {
			char a = s.charAt(0);
			char b = s.charAt(1);
			if (b == '0') {
				if (a != '1' && a != '2')
					ret[2] = 0;
				else
					ret[2] = 1;
			} else {
				if (a == '1')
					ret[2] = 2;
				else if (a == '2') {
					if (b == '7' || b == '8' || b == '9')
						ret[2] = 1;
					else
						ret[2] = 2;
				} else {
					ret[2] = 1;
				}

			}
		}

		for (int i = 2; i < s.length(); i++) {
			char c = s.charAt(i);
			char pre = s.charAt(i - 1);
			if (c == '0') {
				if (pre != '1' && pre != '2')
					return 0;
				else
					ret[i + 1] = ret[i - 1];
			} else {
				if (pre == '1')
					ret[i + 1] = ret[i] + ret[i - 1];
				else if (pre == '2') {
					if (c == '7' || c == '8' || c == '9')
						ret[i + 1] = ret[i];
					else
						ret[i + 1] = ret[i] + ret[i - 1];

				} else
					ret[i + 1] = ret[i];
			}

		}

		return ret[n];
	}
}

// 分清楚情况 0不能单独出现 1必然有两种 2后面不是789  也有两种 不然也是一种
