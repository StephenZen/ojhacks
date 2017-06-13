package leetcode;

/*
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 */

import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;			//记录总长度
        int accumulatedLen = 0;	//记录如果没有单独右括号中断的局部连续长度

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.pop();
                    int matchedLen = i - matchedPos + 1;

                    if (stack.isEmpty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.peek();
                    }

                    maxLen = Math.max(maxLen, matchedLen);
                }
            }
        }

        return maxLen;
	}
}

// 两个全局变量 一个全局最长 一个局部连续
// 左括号 压坐标
// 右括号 如果直接左括号栈是空的 将局部连续清零
// 如果左号栈出栈后变空 更新局部连续, 当前长度为右括号到栈顶左括号的距离
// 更新全局最大
