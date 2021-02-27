package com.zsp1987.leetcode.uncategory;

import java.util.Stack;


/*
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples: "1 + 1" = 2 " 2-1 + 2 " = 3 "(1+(4+5+2)-3)+(6+8)" = 23 Note:
 * Do not use the eval built-in library function.
 */
public class BasicCalculator {
	public int calculate(String s) {
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int n = s.length();
		while (i < n) {
			char c = s.charAt(i);

			if (c == '(')
				stack.push(String.valueOf(c));
			if (c == '-')
				stack.push(String.valueOf(c));
			if (Character.isDigit(c)) {
				sb.append(c);
				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
					sb.append(s.charAt(i + 1));
					i++;
				}
				stack.push(sb.toString());
				sb = new StringBuilder();
			}
			if (c == ')') {
				int temp = 0;
				int pre = 0;
				String str;
				while (!(str = stack.pop()).equals("(")) {
					if (str.equals("-"))
						pre = -pre;
					else {
						temp += pre;
						pre = Integer.valueOf(str);
					}
				}
				temp += pre;
				stack.push(String.valueOf(temp));
			}
			i++;
		}

		int ret = 0;
		int pre = 0;
		while (!stack.isEmpty()) {
			String str = stack.pop();
			if (str.equals("-"))
				pre = -pre;
			else {
				ret += pre;
				pre = Integer.valueOf(str);
			}
		}
		ret += pre;
		return ret;
	}


}
