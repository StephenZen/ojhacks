package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public List<Integer> mergeSort(List<Integer> num) {

		if (num.size() < 2) {
			return num;
		}

		List<Integer> left = num.subList(0, num.size() / 2);
		List<Integer> right = num.subList(num.size() / 2, num.size());

		return merge(mergeSort(left), mergeSort(right));

	}

	List<Integer> merge(List<Integer> left, List<Integer> right) {

		int leftI = 0;
		int rightI = 0;

		List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());

		while (leftI < left.size() && rightI < right.size()) {
			if (left.get(leftI) < right.get(rightI)) {
				merged.add(left.get(leftI));
				leftI++;
			} else {
				merged.add(right.get(rightI));
				rightI++;
			}
		}
		while (leftI < left.size()) {
			merged.add(left.get(leftI));
			leftI++;
		}
		while (rightI < right.size()) {
			merged.add(right.get(rightI));
			rightI++;
		}

		return merged;
	}

}
