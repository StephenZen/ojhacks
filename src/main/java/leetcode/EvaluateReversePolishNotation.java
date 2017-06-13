package leetcode;

/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if (s.equals("+")) {
				int second = stack.pop();
				int first = stack.pop();
				int result = first + second;
				stack.push(result);

			} else if (s.equals("-")) {
				int second = stack.pop();
				int first = stack.pop();
				int result = first - second;
				stack.push(result);

			} else if (s.equals("*")) {
				int second = stack.pop();
				int first = stack.pop();
				int result = first * second;
				stack.push(result);

			} else if (s.equals("/")) {
				int second = stack.pop();
				int first = stack.pop();
				int result = first / second;
				stack.push(result);

			} else {
				int i = Integer.parseInt(s);
				stack.push(i);
			}
		}
		return stack.pop();
	}
}

// 遇到数压栈
// 遇到符号出栈两个 运算后压栈