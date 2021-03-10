package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zsp1987.leetcode.datatype.UndirectedGraphNode;

public class CloneGraph {
	HashMap<UndirectedGraphNode<Integer>, UndirectedGraphNode<Integer>> map = new HashMap<>();

	public UndirectedGraphNode<Integer> cloneGraph(UndirectedGraphNode<Integer> node) {
		if (node == null)
			return null;
		UndirectedGraphNode<Integer> result = cloneNodes(node);
		return result;
	}

	UndirectedGraphNode<Integer> cloneNodes(UndirectedGraphNode<Integer> node) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);

		UndirectedGraphNode<Integer> newNode = new UndirectedGraphNode<>(node.label);
		map.put(node, newNode);
		List<UndirectedGraphNode<Integer>> neighborList = new ArrayList<>();
		for (UndirectedGraphNode<Integer> listNode : node.neighbors) {
			neighborList.add(cloneNodes(listNode));
		}
		newNode.neighbors = neighborList;
		return newNode;
	}
}