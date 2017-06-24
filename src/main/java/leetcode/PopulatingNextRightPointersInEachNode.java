package leetcode;

import datatype.TreeLinkNode;

import java.util.ArrayList;
import java.util.ListIterator;

/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

public class PopulatingNextRightPointersInEachNode {
	 public void connect(TreeLinkNode root) {
	        
	        if(null == root) return;
	        
	        ArrayList<TreeLinkNode> list1 = new ArrayList<TreeLinkNode>();
	        ArrayList<TreeLinkNode> list2 = new ArrayList<TreeLinkNode>();  //to store next row.d
	        
	        list1.add(root);
	        while(list1.size() != 0){
	            ListIterator<TreeLinkNode> i = list1.listIterator();
	            TreeLinkNode current = i.next();
	            while(i.hasNext()){
	                if(null!=current.left){
	                    list2.add(current.left);
	                    list2.add(current.right);		// because the perfect tree;
	                }
	                TreeLinkNode node = i.next();
	                current.next = node;
	                current = node;
	            }
	            if(null!=current.left){
	                    list2.add(current.left);
	                    list2.add(current.right);
	            }
	            current.next=null;
	            list1 = list2;
	            list2 = new ArrayList<TreeLinkNode>();
	        }
	        
	    }
}

// 两个列表 一个保存当前 一个保存下行 迭代替换 知道当前行长度为空
