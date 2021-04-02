package com.zsp1987.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

  public int bfs(Node<Integer> start, Node<Integer> target) {
    Queue<Node<Integer>> queue = new LinkedList<>();
    Set<Node<Integer>> visited = new HashSet<>();

    queue.offer(start);
    visited.add(start);

    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node<Integer> cur = queue.poll();
        if (cur.equals(target)) {
          return level;
        }
        for (Node<Integer> n : cur.adj) {
          if (!visited.contains(n)) {
            queue.offer(n);
            visited.add(n);
          }
        }
      }
      level++;
    }
    return -1;
  }
}

class Node<T> {
  public T value;
  public List<Node<T>> adj;
}
