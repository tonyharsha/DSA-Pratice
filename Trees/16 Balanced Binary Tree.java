/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

  //using height of the tree we can get to know whether its balanced or not.
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftheight=height(root.left);
        int rightheight=height(root.right);
         
        //A tree is said to be balanced only if it is balnaced and its sub trees are also balanced.
        return (Math.abs(leftheight-rightheight)<=1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}