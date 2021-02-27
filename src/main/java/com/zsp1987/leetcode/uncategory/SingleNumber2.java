package com.zsp1987.leetcode.uncategory;
/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */

public class SingleNumber2 {
	public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for (int i=0; i<32; i++){
            for(int j=0; j<A.length; j++){
                count[i] += (A[j] >> i & 1);
            }
            result |= (count[i] % 3) << i;
        }
        
        return result;
    }
}

// 将int的32�? 按照�?�?的顺�?将加和输出到新�?上, 结果除三�?�余数得到独立的数