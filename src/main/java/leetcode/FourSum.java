package leetcode;

/*
 * (k sum questions, look at evernote!) Given an array S of n integers, are
 * there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤
 * b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FourSum {

	public ArrayList<ArrayList<Integer>> fourSumNoPair(int[] num, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) {
							left++;
						}
						while (left < right && num[right] == num[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;
	}

	List<List<Integer>> ret = new ArrayList<List<Integer>>();

	public List<List<Integer>> fourSum(int[] num, int target) {
		class Pair {
			int a;
			int ai;
			int b;
			int bi;

			public Pair(int a, int ai, int b, int bi) {
				this.a = a;
				this.ai = ai;
				this.b = b;
				this.bi = bi;
			}
		}

		if (num == null || num.length < 4)
			return ret;
		Arrays.sort(num);
		TreeMap<Integer, List<Pair>> map = new TreeMap<Integer, List<Pair>>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				if (map.containsKey(sum)) {
					List<Pair> list = map.get(sum);
					list.add(new Pair(num[i], i, num[j], j));
					map.put(sum, list);
				} else {
					List<Pair> list = new ArrayList<Pair>();
					list.add(new Pair(num[i], i, num[j], j));
					map.put(sum, list);
				}

			}
		}

		int ival = map.firstKey();
		int jval = map.lastKey();
		while (ival < jval) {
			if (ival + jval == target) {
				for (Pair ipairs : map.get(ival)) {
					for (Pair jpairs : map.get(jval)) {
						if (jpairs.ai > ipairs.bi || ipairs.ai > jpairs.bi) {
							List<Integer> newList = Arrays.asList(ipairs.a,
									ipairs.b, jpairs.a, jpairs.b);
							if (!ret.contains(newList))
								ret.add(newList);
						}
					}
				}
				jval = map.lowerKey(jval);
				ival = map.higherKey(ival);

			} else if (ival + jval > target) {
				jval = map.lowerKey(jval);

			} else {
				ival = map.higherKey(ival);
			}
		}

		if (ival == jval && ival + jval == target) {
			for (Pair ipairs : map.get(ival)) {
				for (Pair jpairs : map.get(jval)) {
					if (jpairs.ai > ipairs.bi || ipairs.ai > jpairs.bi) {
						if (jpairs.ai > ipairs.bi) {
							List<Integer> newList = Arrays.asList(ipairs.a,
									ipairs.b, jpairs.a, jpairs.b);
							if (!ret.contains(newList))
								ret.add(newList);
						}
					}
				}
			}
		}

		return ret;
	}
}

// 从数列中 取两个数做组合, 以他们的和作为key，indeices作为value加入有序的TreeMap中

// 首尾两个指针 夹出来所以的组合，

// 只加入没有重复的结果
