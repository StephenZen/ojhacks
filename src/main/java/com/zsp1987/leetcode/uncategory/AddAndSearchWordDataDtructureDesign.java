package com.zsp1987.leetcode.uncategory;

import java.util.HashMap;
import com.zsp1987.leetcode.annotation.LeetCode;

/**
 * Design a data structure that supports the following two operations:
 *
 * <p>void addWord(word) bool search(word)
 *
 * <p>search(word) can search a literal word or a regular expression string containing only letters
 * a-z or .. A . means it can represent any one letter.
 *
 * <p>For example:
 *
 * <p>addWord("bad") addWord("dad") addWord("mad") search("pad") -> false search("bad") -> true
 * search(".ad") -> true search("b..") -> true
 */
@LeetCode(54)
public class AddAndSearchWordDataDtructureDesign {

  class Node {
    // Initialize your data structure here.
    HashMap<Character, Node> map;
    boolean isEnd;

    public Node() {
      this.map = new HashMap<Character, Node>();
      this.isEnd = false;
    }
  }

  Node root = new Node();

  // Adds a word into the data structure.
  public void addWord(String word) {
    Node curNode = root;
    int length = word.length();
    for (int i = 0; i < length; i++) {
      char curChar = word.charAt(i);
      if (!curNode.map.containsKey(curChar)) {
        Node nextNode = new Node();
        curNode.map.put(curChar, nextNode);
        curNode = nextNode;
      } else {
        curNode = curNode.map.get(curChar);
      }
    }
    curNode.isEnd = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    Node curNode = root;
    return backSearch(curNode, word, 0);
  }

  boolean backSearch(Node node, String word, int lvl) {
    if (lvl == word.length()) {
      if (!node.isEnd) return false;
      else return true;
    } else {
      char curChar = word.charAt(lvl);
      if (curChar == '.') {
        boolean result = false;
        for (Node nextNode : node.map.values()) {
          result |= backSearch(nextNode, word, lvl + 1);
        }
        return result;
      } else {
        if (!node.map.containsKey(curChar)) return false;
        else return backSearch(node.map.get(curChar), word, lvl + 1);
      }
    }
  }
}
