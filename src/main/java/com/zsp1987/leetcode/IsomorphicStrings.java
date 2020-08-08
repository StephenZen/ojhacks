package com.zsp1987.leetcode;

/*
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */

import java.util.HashMap;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> rmap = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);

			if (map.containsKey(a) || rmap.containsKey(b)) {
				if (!(map.containsKey(a) & rmap.containsKey(b)))
					return false;
				if (map.get(a) == b && rmap.get(b) == a)
					continue;
				else
					return false;
			} else {
				map.put(a, b);
				rmap.put(b, a);
			}
		}

		return true;
	}
}

// 因为完全替�?��?一一对应 所以用两个map检查正�??对应
// �?�?两个map的key的�?�时出现 并且值刚好�??�?�对应, �?然直接返回�?�
