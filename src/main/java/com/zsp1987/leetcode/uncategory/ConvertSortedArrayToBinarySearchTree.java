package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        int n = num.length - 1;
        if (n<0) return null;
        int mid = n / 2;
        TreeNode root = new TreeNode(num[mid]);
        doInsert(num, 0, mid - 1, root, true);
        doInsert(num, mid + 1, n, root, false);
        return root;
    }
    
    void doInsert(int[] num, int s, int e, TreeNode p, Boolean left){
        if(left){	//left side
            if(e < s){
                return;
            }
            else if(e == s){
                TreeNode node = new TreeNode(num[s]);
                p.left = node;
            }
            else if(e == s + 1){
                TreeNode node = new TreeNode(num[e]);
                p.left = node;
                doInsert(num, s, s, node, true);
            }
            else{
                int mid = (s + e) / 2;
                TreeNode node = new TreeNode(num[mid]);
                p.left = node;
                doInsert(num, s, mid - 1, node, true);
                doInsert(num, mid + 1, e, node, false);
            }
        }
        else{	
            if(e < s){
                return;
            }
            else if(e == s){
                TreeNode node = new TreeNode(num[s]);
                p.right = node;
            }
            else if(e == s + 1){
                TreeNode node = new TreeNode(num[s]);
                p.right = node;
                doInsert(num, e, e, node, false);
            }
            else{
                int mid = (s + e)/2;
                TreeNode node = new TreeNode(num[mid]);
                p.right = node;
                doInsert(num, s, mid - 1, node, true);
                doInsert(num, mid + 1, e, node, false);
            }
        }
    }
}

// 二分法递归�?�入, 超过两个,中值为根, 左�?�递归 , 如果有一个直接根节点, 两个的�?end为根, start为根的左节点