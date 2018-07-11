package com.company;

import java.util.*;

public class Leetcode_742_ClosestLeafNode {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*
1. use dfs to construct the undirected graph and find the start node

2. use bfs to search the graph from start node to any leaf node

3. Time : O(n) Space: O(n)
*/
    class Solution {
        public int findClosestLeaf(TreeNode root, int k) {
            Map<TreeNode, TreeNode> map = new HashMap<>();  // store all the back edges that is from child to parent
            Queue<TreeNode> queue = new LinkedList<>(); // used in BFS
            List<TreeNode> visited = new ArrayList<>();

            TreeNode knode = DFS(root, k, map);
            queue.add(knode);
            visited.add(knode);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null) { // if it is a leaf node
                    return cur.val;
                }

                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.add(cur.left);
                    visited.add(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.add(cur.right);
                    visited.add(cur.right);
                }

                if (map.containsKey(cur) && !visited.contains(map.get(cur))) {
                    queue.add(map.get(cur));
                    visited.add(map.get(cur));
                }

            }

            return -1;
        }


        public TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
            if (root.val == k) return root;

            if (root.left != null) {
                map.put(root.left, root);
                TreeNode left = DFS(root.left, k, map);
                if (left != null) return left;
            }

            if (root.right != null) {
                map.put(root.right, root);
                TreeNode right = DFS(root.right, k, map);
                if (right != null) return right;
            }

            return null;
        }
    }
}
