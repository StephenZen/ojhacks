package leetcode;

/*
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
import datatype.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
	HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode result = cloneNodes(node);
		return result;
	}

	UndirectedGraphNode cloneNodes(UndirectedGraphNode node) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		List<UndirectedGraphNode> neighborList = new ArrayList<UndirectedGraphNode>();
		for (UndirectedGraphNode listNode : node.neighbors) {
			neighborList.add(cloneNodes(listNode));
		}
		newNode.neighbors = neighborList;
		return newNode;
	}
}

//用hashmap储存克隆过的对象, 对新克隆对象的list加入老node中的list的clone版本