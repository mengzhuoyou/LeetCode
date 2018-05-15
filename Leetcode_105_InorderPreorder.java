/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//For this problem, we know that the first element in the preorder sequence is the root for the current tree, so we find this element in the inorder sequence. Then, the elemnts before this position is the left children, the elements after this position is the right children.

class Solution {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,preorder.length);
        //the last parameter means: the length of the current tree;
    }

    public TreeNode build(int[] preorder, int[] inorder, int idx1, int idx2, int len){
        if(len == 0) return null;

        TreeNode root = new TreeNode(preorder[idx1]);

        //to find the left length of this root
        int leftLen = 0;
        while(inorder[idx2+leftLen] != preorder[idx1]) leftLen++;

        root.left = build(preorder, inorder, idx1+1, idx2, leftLen);
        root.right = build(preorder, inorder, idx1+leftLen+1, idx2+leftLen+1, len-leftLen-1);

        return root;
    }
}