package leetcode;

/*
 Given two words (start and end), and a dictionary, 
 find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary

 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]

 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.

 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		int result = 0;
		if (dict.size() == 0) {
			return result;
		}

		dict.add(start);
		dict.add(end);

		result = BFS(start, end, dict);

		return result;
	}

	int BFS(String start, String end, Set<String> dict) {

		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();
		queue.add(start);
		length.add(1);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			int len = length.poll();

			if (word.equals(end)) {
				return len;
			}

			for (int i = 0; i < word.length(); i++) {
				char[] arr = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == arr[i])
						continue;

					arr[i] = c;
					String str = String.valueOf(arr);
					if (dict.contains(str)) {
						queue.add(str);
						length.add(len + 1);
						dict.remove(str);
					}
				}
			}
		}

		return 0;
	}
}

// use bfs to find, and a length list to store the step that reach the end. 