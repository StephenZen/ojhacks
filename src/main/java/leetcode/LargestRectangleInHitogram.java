package leetcode;

/*
 Given n non-negative integers representing the histogram's bar height 
 where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given height = [2,1,5,6,2,3],
 return 10.


 */

import java.util.Stack;

public class LargestRectangleInHitogram {
	public int largestRectangleArea(int[] height) {
		if (height == null)
			return 0;// Should throw exception
		if (height.length == 0)
			return 0;

		Stack<Integer> index = new Stack<Integer>();
		index.push(-1);
		int max = 0;

		for (int i = 0; i < height.length; i++) {
			// Start calculate the max value
			while (index.peek() > -1) {
				if (height[index.peek()] > height[i]) {
					int top = index.pop();
					max = Math.max(max, height[top] * (i - 1 - index.peek()));
				} else
					break;
			}

			index.push(i);
		}
		while (index.peek() != -1) {
			int top = index.pop();
			max = Math.max(max, height[top]
					* (height.length - 1 - index.peek()));
		}
		return max;
	}
}

// 维护一个高度递涨的栈, 如果当前高度比最高高度低 就往回计算, 知道算到最后 在往回计算一边
