package com.zsp1987.leetcode.uncategory;

/*
 Given a string s and a dictionary of words dict,
 add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"]. 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	List<String> ret = new ArrayList<String>();
	List<String> list = new ArrayList<String>();
	Boolean[] p;	// condition to prune

	public List<String> wordBreak(String s, Set<String> dict) {

		if (s == null || s.length() == 0)
			return ret;
		p = new Boolean[s.length() + 1];
		process(s, dict, 0, 0);
		return ret;
	}

	public void process(String s, Set<String> dict, int pos, int lvl) {
		if (lvl == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String item : list) {
				sb.append(item);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			ret.add(sb.toString());
			return;
		}

		while (lvl < s.length()) {
			String cur = s.substring(pos, lvl + 1);
			if (dict.contains(cur)
					&& (p[lvl + 1] == null || p[lvl + 1] != false)) {
				int size = ret.size();
				list.add(cur);
				process(s, dict, lvl + 1, lvl + 1);
				if (ret.size() == size) {		// 根�?�结果的长度�?�化,
												// 判断之�?�是�?��?�能
					p[lvl + 1] = false;
				}
				list.remove(list.size() - 1);
			}
			lvl++;
		}
	}

}

// 回溯 , 改进的方法是在调用回溯之�?检查之�?是�?�算过, 如果算过直接剪�?