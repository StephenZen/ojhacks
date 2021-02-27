package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are given
 * the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings
 * collectively (Figure B).
 * 
 * The geometric information of each building is represented by a triplet of
 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
 * right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
 * may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 */
public class TheSkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0) {
			return Collections.emptyList();
		}

		List<int[]> res = new ArrayList<int[]>();
		ArrayList<BuildingNode> nodes = new ArrayList<BuildingNode>();
		for (int[] n : buildings) {
			nodes.add(new BuildingNode(n[0], n[2], true));
			nodes.add(new BuildingNode(n[1], n[2], false));
		}

		Collections.sort(nodes);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,
				Collections.reverseOrder());
		BuildingNode pre = null;
		for (int i = 0; i < nodes.size(); i++) {
			BuildingNode n = nodes.get(i);
			BuildingNode next = i + 1 < nodes.size() ? nodes.get(i + 1) : null;
			if (n.isLeft) {
				// is the current start line is the same with the previous one,
				// ignore it
				if (pre == null || !(n.y == pre.y && n.x == pre.x)) {
					if (pq.isEmpty()) {
						res.add(new int[] { n.x, n.y });
					} else if (n.y > pq.peek()) {
						res.add(new int[] { n.x, n.y });
					}
				}
				pq.add(n.y);
			} else if (!n.isLeft) {
				pq.remove(n.y);
				if (next == null || n.x != next.x) {
					if (!(pq.isEmpty()) && n.y > pq.peek()) {
						res.add(new int[] { n.x, pq.peek() });
					} else if (pq.isEmpty()) {
						res.add(new int[] { n.x, 0 });
					}
				}
			}
			pre = n;
		}
		return res;

	}

	private static class BuildingNode implements Comparable<BuildingNode> {
		int x;
		int y;
		boolean isLeft;

		public BuildingNode(int x, int y, boolean isLeft) {
			this.x = x;
			this.y = y;
			this.isLeft = isLeft;
		}

		public int compareTo(BuildingNode o) {
			if (x != o.x) {
				return x - o.x;
			} else if (isLeft != o.isLeft) {
				return isLeft ? 1 : -1;
			} else if (y != o.y) {
				if (isLeft)
					return o.y - y;
				else
					return y - o.y;
			}
			return 0;
		}
	}

}

// 首先建立节点类 有三个类域 一个横�??标 一个纵�??标 一个判断是左节点还是�?�节点
// 实现comparable 原则是横�??标�?�?� 横�??标�?的大, 左节点永远大于�?�节点, �?�则�?�为左节点 高度高的在�?, �?�为�?�节点, 高度低的在�?
// 加入节点进列表 根�?�高度排�?
// 从列表�?次�?�出中�?�出 碰到左节点 将节点加入一个维护高度的PriporitoryQueue中, 如果次节点高度比queue中的最高高度高, 将次节点加入结果
// 如果是�?�节点 将当�?节点的高度从queue中删除, 如果当�?节点比queue中最高节点高(原�?�的最高纵�??标就是当�?节点) 加入当�?节点的横�??标和queue的最高heigh
// 如果queue已�?为空 加入当�?横�??标和0作为纵�??标
