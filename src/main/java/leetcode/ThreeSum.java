package leetcode;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤
 * c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return ret;

		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] > num[i - 1]) { // avoid duplicated
				int j = i + 1, k = num.length - 1;
				while (j < k) {
					if (num[j] + num[k] == -num[i]) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						ret.add(temp);
						j++;
						k--;
						while (k > j && num[k] == num[k + 1])
							k--;// avoid duplicate solutions
						while (j < k && num[j] == num[j - 1])
							j++;// avoid duplicate solutions
					} else if (num[j] + num[k] > -num[i]) {
						k--;
					} else {
						j++;
					}
				}

			}
		}

		return ret;
	}

	@Test
	public void threeSumTest() {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		ThreeSum t = new ThreeSum();
		List<List<Integer>> ret = t.threeSum(num);
		Assert.assertEquals(2, ret.size());
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(-1, 0, 1));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(-1, -1, 2));
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		expected.add(list2);
		expected.add(list1);
		Assert.assertEquals(expected, ret);
	}
}

// 先排序,选定一个点，从两头夹, 剩余两点之和应该等于选定点的负值，相邻两点值同就跳过

