package com.zsp1987.leetcode;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		int n = s.length();
		if (n == 0)
			return true;
		if (n % 2 != 0)
			return false;
		else {
			for (int i = 0; i < n; i++) {
				char cur = s.charAt(i);
				if (cur == '(' || cur == '[' || cur == '{') {
					stack.push(cur);
				} else if (cur == ')') {
					if (stack.isEmpty())
						return false;
					if ('(' != stack.pop())
						return false;
				} else if (cur == ']') {
					if (stack.isEmpty())
						return false;
					if ('[' != stack.pop())
						return false;
				} else if (cur == '}') {
					if (stack.isEmpty())
						return false;
					if ('{' != stack.pop())
						return false;
				} else {
					return false;
				}

			}
			return stack.isEmpty();
		}
	}
}

/*
 * 压stack 出stack
 */
