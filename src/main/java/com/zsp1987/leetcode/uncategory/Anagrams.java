package com.zsp1987.leetcode.uncategory;

/*
 Given an array of strings, return all groups of strings that are anagrams.

 Note: All inputs will be in lower-case.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    List<String> result = new ArrayList<String>();
    HashMap<String, String> map = new HashMap<String, String>();
    HashMap<String, Integer> count = new HashMap<String, Integer>();

    public List<String> anagrams(String[] strs) {
        if (strs == null)
            return result;
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(toSort(strs[i]))
                    && count.get(toSort(strs[i])) == 0) {
                result.add(map.get(toSort(strs[i])));
                result.add(strs[i]);
                count.put(toSort(strs[i]), 1);
            } else if (map.containsKey(toSort(strs[i]))) {
                result.add(strs[i]);
            } else {
                map.put(toSort(strs[i]), strs[i]);
                count.put(toSort(strs[i]), 0);
            }
        }
        return result;
    }

    String toSort(String str) {
        char[] chas = str.toCharArray();
        Arrays.sort(chas);
        return new String(chas);
    }
}

/*
 *  anagram is string with same characters,
 *  idea is sort the string, put on hashmap.
 */
