package leetcode;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/*
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"

 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
 */

public class MinimumWindowSubstring {

	/*
	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow("a", "aa"));
	}
	*/

	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0)
			return "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		int left = 0;
		int count = 0;
		int minLen = S.length() + 1;
		int minStart = 0;
		for (int right = 0; right < S.length(); right++) {
			if (map.containsKey(S.charAt(right))) {
				map.put(S.charAt(right), map.get(S.charAt(right)) - 1);
				if (map.get(S.charAt(right)) >= 0) {
					count++;
				}
				while (count == T.length()) {
					if (right - left + 1 < minLen) {
						minLen = right - left + 1;
						minStart = left;
					}
					if (map.containsKey(S.charAt(left))) {
						map.put(S.charAt(left), map.get(S.charAt(left)) + 1);
						if (map.get(S.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > S.length()) {
			return "";
		}
		return S.substring(minStart, minStart + minLen);
	}
	
	@Test
	public void minWindowTest(){
		String S = "fjebieifeislie";
		String T = "fesl";
		Assert.assertEquals("feisl", minWindow(S, T));
	}

}

// 先建立 T的hash表 从左向右扫S 碰见相同就减map 到T长度就见左边