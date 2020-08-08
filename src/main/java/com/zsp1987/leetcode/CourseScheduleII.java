package com.zsp1987.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * 
 * There are a total of 4 courses to take. To take course 3 you should have
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. So one correct course order is [0,1,2,3]. Another correct
 * ordering is[0,2,1,3].
 */

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		} else {
			HashSet<Integer>[] graph = new HashSet[numCourses];
			for (int i = 0; i < numCourses; i++) {
				graph[i] = new HashSet<Integer>();
			}
			for (int[] pair : prerequisites) {
				graph[pair[1]].add(pair[0]);
			}
			boolean[] visited = new boolean[numCourses];
			boolean[] visiting = new boolean[numCourses];
			ArrayList<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < numCourses; i++) {
				if (!visited[i]) {
					boolean dfsResult = dfs(graph, i, visited, visiting, list);
					if (!dfsResult)
						return result;
				}
			}

			for (int i = 0; i < numCourses; i++) {
				result[i] = list.get(numCourses - 1 - i);
			}
			return result;
		}

	}

	boolean dfs(HashSet<Integer>[] graph, int i, boolean[] visited,
			boolean[] visiting, ArrayList<Integer> list) {
		if (visiting[i]) {
			return false;
		}
		visiting[i] = true;
		for (Integer integer : graph[i]) {
			if (!visited[integer]) {
				if (!dfs(graph, integer, visited, visiting, list))
					return false;
			}
		}
		visiting[i] = false;
		list.add(i);
		visited[i] = true;
		return true;
	}

	public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int[][] graph = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (graph[pre][ready] == 0)
				indegree[ready]++;
			graph[pre][ready] = 1;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			list.add(course);
			for (int i = 0; i < numCourses; i++) {
				if (graph[course][i] != 0) {
					if (--indegree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		if (list.size() != numCourses)
			return new int[0];
		else {
			for (int i = 0; i < numCourses; i++) {
				result[i] = list.get(i);
			}
			return result;
		}

	}
}

// 跟1的�?路一样, 唯一区别就是加了个list�?�记录顺�?