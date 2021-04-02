package com.zsp1987.leetcode.algorithm.sort;

import java.util.LinkedList;
import java.util.List;



public class InsertSort {

	public List<Integer> insertSort(List<Integer> num) {
		int n = num.size();
		List<Integer> sortedList = new LinkedList<Integer>();

		Outer: for (int i = 0; i < n; i++) {
			for (int j = 0; j < sortedList.size(); j++) {
				if (num.get(i) < sortedList.get(j)) {
					sortedList.add(j, num.get(i));
					continue Outer;
				}
			}
			sortedList.add(sortedList.size(), num.get(i));
		}

		return sortedList;
	}


}
