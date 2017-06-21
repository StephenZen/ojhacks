package bitoperator;

/*
Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory? 
 */

public class SingleNumber {
    public int singleNumber(int[] A) {
        int val = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            val = val ^ A[i]; // ^ operation will make the duplicate int into 0000
        }
        return val;
    }
}