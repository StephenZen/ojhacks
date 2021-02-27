package com.zsp1987.leetcode.uncategory;

/*
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null)
			return 0;
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int i = 0;
		int j = 0;
		while (i < v1.length && j < v2.length) {
			if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[j])) {
				return 1;
			} else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])) {
				return -1;
			} else {
				i++;
				j++;
			}
		}
		while (i < v1.length) {
			if (Integer.parseInt(v1[i]) != 0)
				return 1;
			else
				i++;
		}
		while (j < v2.length) {
			if (Integer.parseInt(v2[j]) != 0)
				return -1;
			else
				j++;
		}
		return 0;

	}
}

// 将版本�?�用.分割
// �?次比较段大�?, 如果比出, 直接返回.
// 若到一方比完还没分出大�?, �?�一方必须全为0, �?�则�?�一方就大
