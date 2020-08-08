package com.zsp1987.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 11)
			return res;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> unique = new HashSet<Integer>();

		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i < 9) {
				hash = (hash << 2) + map.get(c);
			} else {
				hash = (hash << 2) + map.get(c);
				hash &= (1 << 20) - 1;
				if (set.contains(hash) && !unique.contains(hash)) {
					res.add(s.substring(i - 9, i + 1));
					unique.add(hash);
				} else {
					set.add(hash);
				}
			}
		}

		return res;

	}
}
// 将ACGT表示为 00, 01, 10, 11
// 将字符串对比 改�?用bit�?作的hashcode的对比
// 用set记录出现过的hash �?�现�?�?就将字符串加入到结果