package com.company;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_272_ClosestBinaryTreeValue2 {
    /**
     * Definition for a binary tree node
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*
  keep a queue size of k, each time we traverse a node, we add it to the tail of the queue, and compare the head and tail of the uqeue, and delete one of two.
*/
    class Solution {
        List<Integer> res = new LinkedList<>();

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            if (root == null) return res;
            traverse(root, target, k);
            return res;
        }

        public void traverse(TreeNode cur, double target, int k) {
            if(cur == null) return;
            traverse(cur.left, target, k);

            //do our buisness here
            if (res.size() < k) {
                res.add(cur.val);
            } else if (Math.abs(res.get(0) - target) > Math.abs(cur.val - target)) {
                res.add(cur.val);
                res.remove(0);
            } else { // if reach here, it means cur.val is far away from the target than the node in the queue, so we don't need to go to the right child
                return;
            }


            traverse(cur.right, target, k);
        }
    }
}
