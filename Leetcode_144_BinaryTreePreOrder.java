package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_144_BinaryTreePreOrder {
    /**
     * Definition for a binary tree node
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);

                if(cur.right != null) {
                    stack.push(cur.right);
                }

                if(cur.left != null) {
                    stack.push(cur.left);
                }

            }

            return res;

//         List<Integer> res = new ArrayList<>();
//         if(root == null) return res;

//         TreeNode cur = root;
//         while(cur != null) {
//             if(cur.left == null) {
//                 res.add(cur.val);
//                 cur = cur.right;
//             } else {
//                 TreeNode prev = cur.left;
//                 while(prev.right != null && prev.right != cur) {
//                     prev = prev.right;
//                 }

//                 if(prev.right == null) {
//                     res.add(cur.val);
//                     prev.right = cur;
//                     cur = cur.left;
//                 } else {
//                     //res.add(cur.val); inorder
//                     prev.right = null;
//                     cur = cur.right;
//                 }
//             }
//         }

//         return res;
        }
    }
}
