package com.zsp1987.leetcode.uncategory;
/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n == 0) return b;
        if (m == 0) return a;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (n != 0 && m != 0) {
            int i = a.charAt(n - 1) + b.charAt(m - 1) + carry - '0' * 2;
            if (i == 0) {
                sb.append(0);
                carry = 0;
            } else if (i == 1) {
                sb.append(1);
                carry = 0;
            } else if (i == 2) {
                sb.append(0);
                carry = 1;
            } else if (i == 3) {
                sb.append(1);
                carry = 1;
            }
            n--;
            m--;
        }

        while (n != 0) {
            int i = a.charAt(n - 1) + carry - '0';
            if (i == 0) {
                sb.append(0);
                carry = 0;
            } else if (i == 1) {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(0);
                carry = 1;
            }
            n--;
        }

        while (m != 0) {
            int i = b.charAt(m - 1) + carry - '0';
            if (i == 0) {
                sb.append(0);
                carry = 0;
            } else if (i == 1) {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(0);
                carry = 1;
            }
            m--;
        }

        if (carry != 0) sb.append(1);
        return sb.reverse().toString();

    }
}