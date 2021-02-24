package com.zsp1987.leetcode.uncategory;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	// dfs topological sort
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0)
			return true;
		HashSet<Integer>[] graph = new HashSet[numCourses]; // adjcent list
		for (int i = 0; i < numCourses; i++)
			graph[i] = new HashSet<Integer>();
		for (int i = 0; i < prerequisites.length; i++)
			graph[prerequisites[i][1]].add(prerequisites[i][0]);

		boolean visited[] = new boolean[numCourses];
		boolean visiting[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				if (!(dfs(graph, visited, visiting, i)))
					return false;
			}
		}

		return true;
	}

	boolean dfs(HashSet<Integer>[] graph, boolean[] visited,
			boolean[] visiting, int i) {
		if (visiting[i])
			return false;
		visiting[i] = true;
		for (Integer integer : graph[i]) {
			if (!visited[integer]) {
				if (!dfs(graph, visited, visiting, integer))
					return false;
			}
		}
		visiting[i] = false;
		visited[i] = true;
		return true;

	}

	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // adjacent matrix
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0)
				indegree[ready]++;
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}

}

// topological sort 根�?�ITA的方法 应该是用DFS
// bfs �?路:
// 用的是从没有incoming edge的顶点出�?�, 将其移除, 并检查从其出�?�的边的终点, 如果将边移除会�?��?没有incoming edge的顶点,
// 将其也加入队列
// 最�?�检查加入list个数 是�?�与总个数相�?�
