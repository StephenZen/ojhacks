package leetcode;

/*
Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory? 
 */

public class SingleNumber {
public int singleNumber(int[] A){
		
		int val = 0;
		for(int i=0; i< A.length; i++){
			val = val^A[i];
		}
		
		return val;
	}
}


// because ^ operation will make the duplicate int into 0000