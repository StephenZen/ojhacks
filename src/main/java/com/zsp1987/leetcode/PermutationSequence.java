package com.zsp1987.leetcode;

/*
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the kth permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.
 (count one by one will lead to time out, so try find the number directly)
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int total = factorial(n);
        StringBuffer candidate = new StringBuffer("123456789");
        candidate.substring(0, n);
        StringBuffer result = new StringBuffer();

        // count every bit
        for (int i = 0; i < n; i++) {
            total /= (n - i);
            int index = (k - 1) / total;
            result.append(candidate.charAt(index));
            candidate.deleteCharAt(index);
            k -= index * total;
        }
        return result.toString();
    }

    int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
// n个数字有n!�?排列
// �?次处以(n-1)!得到当�?的index
// �?次�?�入就好了
