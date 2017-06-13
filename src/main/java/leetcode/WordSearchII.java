package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
/*
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Return ["eat","oath"]. 
 */
import java.util.List;
import java.util.Set;

public class WordSearchII {

	Set<String> res = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		MyTrie trie = new MyTrie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, boolean[][] visited, String str, int x,
			int y, MyTrie trie) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if (visited[x][y])
			return;

		str += board[x][y];
		if (!trie.startsWith(str))
			return;

		if (trie.search(str)) {
			res.add(str);
		}

		visited[x][y] = true;
		dfs(board, visited, str, x - 1, y, trie);
		dfs(board, visited, str, x + 1, y, trie);
		dfs(board, visited, str, x, y - 1, trie);
		dfs(board, visited, str, x, y + 1, trie);
		visited[x][y] = false;
	}

	class MyTrie {
		class TrieNode {
			public TrieNode[] children = new TrieNode[26];
			public String item = "";

			public TrieNode() {
			}
		}

		private TrieNode root;

		public MyTrie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.item = word;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return node.item.equals(word);
		}

		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (char c : prefix.toCharArray()) {
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return true;
		}
	}
}
