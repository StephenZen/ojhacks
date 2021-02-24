package com.zsp1987.leetcode.uncategory;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack<E> {

	Queue<E> q = new ArrayDeque<E>();

	// Push element x onto stack.
	public void push(E x) {
		q.offer(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		Queue<E> q2 = new ArrayDeque<E>();
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
	public E top() {
		Queue<E> q2 = new ArrayDeque<E>();
		int n = q.size();
		for (int i = 0; i < n - 1; i++) {
			E temp = q.poll();
			q2.offer(temp);
		}

		E top = q.peek();
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
