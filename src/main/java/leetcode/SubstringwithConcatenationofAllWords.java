package leetcode;

/*
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	List<Integer> ret = new ArrayList<Integer>();

	public List<Integer> findSubstring(String S, String[] L) {
		int n = S.length();
		int m = L.length;
		if (n == 0 || m == 0)
			return ret;
		int k = L[0].length();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < m; i++) {
			if (map.containsKey(L[i])) {
				map.put(L[i], map.get(L[i]) + 1);
			} else {
				map.put(L[i], 1);
			}
		}

		for (int i = 0; i < n - m * k + 1; i++) {
			HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
			for (int j = 0; j < m; j++) {
				String s = S.substring(i + j * k, i + (j + 1) * k);
				if (temp.containsKey(s)) {
					if (temp.get(s) - 1 == 0) {
						temp.remove(s);
					} else {
						temp.put(s, temp.get(s) - 1);
					}
				} else {
					break;
				}
			}
			if (temp.size() == 0)
				ret.add(i);
		}
		return ret;
	}

}

// 将字符串依次添加到hashmap里, 循环原字符串, 每次检查长度为候选数组之和, 碰见不在map里就直接返回, 不然counter减一
