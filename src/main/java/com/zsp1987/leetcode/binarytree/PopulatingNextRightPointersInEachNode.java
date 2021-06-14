package com.zsp1987.leetcode.binarytree;

import java.util.ArrayList;
import java.util.ListIterator;
import com.zsp1987.leetcode.annotation.LeetCode;

@LeetCode(116)
public class PopulatingNextRightPointersInEachNode {
	public void connect(Node root) {

		if (null == root)
			return;

		ArrayList<Node> list1 = new ArrayList<Node>();
		ArrayList<Node> list2 = new ArrayList<Node>(); // to store next row.d

		list1.add(root);
		while (list1.size() != 0) {
			ListIterator<Node> i = list1.listIterator();
			Node current = i.next();
			while (i.hasNext()) {
				if (null != current.left) {
					list2.add(current.left);
					list2.add(current.right); // because the perfect tree;
				}
				Node node = i.next();
				current.next = node;
				current = node;
			}
			if (null != current.left) {
				list2.add(current.left);
				list2.add(current.right);
			}
			current.next = null;
			list1 = list2;
			list2 = new ArrayList<Node>();
		}

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}
