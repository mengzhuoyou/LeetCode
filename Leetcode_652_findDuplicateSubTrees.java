package com.company;

import java.util.*;

public class Leetcode_652_findDuplicateSubTrees {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    
    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            preorder(res, map, root);

            for (String key : map.keySet()) {
                System.out.println(key);
            }
            return res;
        }

        public String preorder(List<TreeNode> res, Map<String, Integer> map, TreeNode cur) {
            if (cur == null) return "#";

            String serial = cur.val + "," + preorder(res, map, cur.left) +  "," + preorder(res, map, cur.right);
            if (map.containsKey(serial) && map.get(serial) == 1) {
                res.add(cur);
                map.put(serial, map.get(serial) + 1);
            } else {
                map.put(serial, map.getOrDefault(serial, 0) + 1);
            }

            return serial;
        }
    }
}
