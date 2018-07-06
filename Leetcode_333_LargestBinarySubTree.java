package com.company;

public class Leetcode_333_LargestBinarySubTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int maxSize = 0;

        public int largestBSTSubtree(TreeNode root) {
            dfs(root);
            return maxSize;
        }

        //dfs(cur) --> current node's sub-binary tree's [0]:size [1]:min value [2]:max value
        public int[] dfs(TreeNode root) {
            if(root == null) return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
            // return this means every node is valid BST

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            if(root.val > left[2] && root.val < right[1]) {
                int min = Math.min(root.val, left[1]);
                int max = Math.max(root.val, right[2]);

                maxSize = Math.max(maxSize, left[0]+right[0]+1);

                return new int[] {left[0] + right[0] + 1, min, max};
            }

            return new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
            //return this means this node's parent node cannot be valid BST
        }
    }




}
