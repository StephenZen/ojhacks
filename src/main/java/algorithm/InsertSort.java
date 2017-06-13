package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

	@Test
	public void insertSortTest() {

		List<Integer> input = new ArrayList<Integer>();
		input.addAll(Arrays.asList(4, 2, 1, 3));
		List<Integer> output = new ArrayList<Integer>();
		output.addAll(Arrays.asList(1, 2, 3, 4));

		List<Integer> sorted = insertSort(input);

		Assert.assertArrayEquals(sorted.toArray(), output.toArray());
	}
}
