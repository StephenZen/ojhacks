package com.zsp1987.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.zsp1987.leetcode.datatype.RandomListNode;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
		return copyRandomList(head, nodeMap);
	}

	public RandomListNode copyRandomList(RandomListNode head,
			Map<RandomListNode, RandomListNode> nodeMap) {
		if (head == null) {
			return null;
		}
		if (nodeMap.containsKey(head)) {
			return nodeMap.get(head);
		}

		RandomListNode node = new RandomListNode(head.label);
		nodeMap.put(head, node);
		node.next = copyRandomList(head.next, nodeMap);
		node.random = copyRandomList(head.random, nodeMap);
		return node;
	}
}

// 跟clonegraph很�? 都是用到hashmap储存 和递归调用copy的方法