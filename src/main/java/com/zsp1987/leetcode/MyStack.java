package com.zsp1987.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

	Queue q = new ArrayDeque();

	// Push element x onto stack.
	public void push(int x) {
		q.offer(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		Queue q2 = new ArrayDeque();
		int n = q.size();
		for (int i = 0; i < n - 1; i++) {
			q2.offer(q.poll());
		}
		q.poll();
		while (!q2.isEmpty()) {
			q.offer(q2.poll());
		}
	}

	// Get the top element.
	public int top() {
		Queue q2 = new ArrayDeque();
		int n = q.size();
		for (int i = 0; i < n - 1; i++) {
			int temp = (Integer) q.poll();
			q2.offer(temp);
		}

		int top = (Integer) q.peek();
		q2.offer(q.poll());
		while (!q2.isEmpty()) {
			q.offer(q2.poll());
		}
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q.isEmpty();
	}
}
