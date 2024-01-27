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
  //Using the concept of inorder traversal 
    //We are comparing diff between adjacent elements so we are using inorder hence the data will be sortd
    //to compare we need an previous val so maintined and previous variable.
class Solution {
    int res=Integer.MAX_VALUE;
    int previous=-1;
    public int minDiffInBST(TreeNode root) {
        if(root==null) return 0;
        minDiffInBST(root.left);
        if(previous!=-1)
           res=Math.min(res,root.val-previous);
        previous=root.val;
        minDiffInBST(root.right);

        return res;
    }
}