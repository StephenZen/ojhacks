package algorithm;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public List<Integer> quickSort(List<Integer> num) {
		if (num.size() < 2)
			return num;

		int pivot = num.get(0);
		List<Integer> lower = new ArrayList<Integer>();
		List<Integer> higher = new ArrayList<Integer>();

		for (int i = 1; i < num.size(); i++) {
			if (num.get(i) < pivot) {
				lower.add(num.get(i));
			} else {
				higher.add(num.get(i));
			}
		}

		List<Integer> sorted = quickSort(lower);
		sorted.add(pivot);
		sorted.addAll(quickSort(higher));

		return sorted;

	}

}
