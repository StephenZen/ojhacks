package leetcode;

/*
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3. For "bbbbb" the longest substring is "b",
 * with the length of 1.
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		int max = 0;
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			count++;
			if (map.containsKey(ch[i])) {
				count = Math.min(count, i - map.get(ch[i]));
			}
			map.put(ch[i], i);
			if (count > max)
				max = count;
		}
		return max;
	}

}
/*
 * 储存位置，碰到重复，重置左指针
 */