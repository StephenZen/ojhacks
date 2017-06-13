package leetcode;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

public class CountAndSay {
	public String countAndSay(int n) {

		int count = 1;
		String s = String.valueOf(1);
		while (count < n) {
			s = readoff(s);
			count++;
		}
		return s;

	}

	String readoff(String s) {
		int m = s.length();
		StringBuilder sb = new StringBuilder();
		char cur = s.charAt(0);
		int count = 1;
		for (int i = 1; i < m; i++) {
			if (s.charAt(i) != cur) {
				sb.append(count);
				sb.append(cur);
				count = 1;
				cur = s.charAt(i);
			} else {
				count++;
			}
		}
		sb.append(count);
		sb.append(cur);

		return sb.toString();
	}
}

// 先读 然后得到结果迭代到下次