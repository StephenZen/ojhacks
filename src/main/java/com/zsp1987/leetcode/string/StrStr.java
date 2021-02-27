package com.zsp1987.leetcode.string;

public class StrStr{
    public int strStr(String source, String target) {
        if (null == source || null == target) {
            return -1;
        }
        int i = 0;
        int j = 0;

        for (; i < source.length() - target.length() + 1; i++) {
            for (; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
