package com.zsp1987.leetcode;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity. 
 */
import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i: num){
            hs.put(i, 0);
        }
        int maxl = 1;
        for(int i: num){
            if (hs.get(i) == 1) continue;

            int tmp = i;
            int current_max = 1;
            while(hs.containsKey(tmp+1)){
                current_max ++;
                tmp ++;
                hs.put(tmp, 1);
            }

            tmp = i;
            while(hs.containsKey(tmp-1)){
                current_max ++;
                tmp --;
                hs.put(tmp, 1);
            }

            maxl = Math.max(current_max, maxl);
        }

        return maxl;
    }
	
	public int longestConsecutiveOld(int[] num) {
		int n = num.length;
		if (n == 0)
			return 0;
		Arrays.sort(num);		// problem this should be O(nlogn)
		int count = 1;
		int max = count;
		int pre = num[0];
		for (int i = 1; i < n; i++) {
			if (num[i] - pre > 1) {
				if (count > max) {
					max = count;
				}
				count = 1;
			} else if (num[i] - pre == 1) {
				count++;
			}
			pre = num[i];
		}
		if (count > max) {
			max = count;
		}
		return max;
	}
}

// 将�?个元素分别�?�左�?�查找, 用hashmap存查找�?历 如果查过了就�?�?�?多查一边了