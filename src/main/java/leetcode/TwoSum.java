package leetcode;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers
  (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

public class TwoSum {


	public int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			if (map.containsKey(target - cur)) {

				ret[0] = map.get(target - cur) + 1;
				ret[1] = i + 1;
				break;

			}
			map.put(cur, i);
		}
		return ret;

	}
	
	@Test
	public void twoSumTest(){
		int[] numbers = { 2, 7, 11, 15 };
		int[] ret = twoSum(numbers, 9);
		Assert.assertEquals(ret[0], 1);
		Assert.assertEquals(ret[1], 2);
	}
}

// hash列表保存 查每个数的target差值是否已经在hash里了