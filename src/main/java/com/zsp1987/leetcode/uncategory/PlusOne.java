package com.zsp1987.leetcode.uncategory;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 
 123 = [1,2,3]
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        return helper(digits, n - 1);
    }

    int[] helper(int[] digits, int pos) {
        if (digits[pos] + 1 < 10) {
            digits[pos] = digits[pos] + 1;
            return digits;
        }
        if (pos > 0 && digits[pos] + 1 == 10) {
            digits[pos] = 0;
            return helper(digits, pos - 1);
        } else {
            int n = digits.length;
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            return newDigits; // 99999 => 100000
        }
    }
}
