package com.company;

public class Leetcode_106_preorderpostorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, postorder, 0, 0, postorder.length);
        }

        public TreeNode build(int[] inorder, int[] postorder, int idx1, int idx2, int len){
            if(len == 0) return null;

            TreeNode root = new TreeNode(postorder[idx2+len-1]);
            int leftLen = 0;
            while(inorder[idx1+leftLen] != postorder[idx2+len-1]) leftLen++;

            root.left = build(inorder, postorder, idx1, idx2, leftLen);
            root.right = build(inorder, postorder, idx1+leftLen+1, idx2+leftLen, len-leftLen-1);

            return root;
        }

    }
}
