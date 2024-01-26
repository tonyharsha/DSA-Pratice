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
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        TreeNode leftnode=root.left;
        TreeNode rightnode=root.right;
        
        //if sub tree has only right node in that case consider depth of right tree +1.
        if(leftnode==null && rightnode!=null){
            return 1+minDepth(rightnode);
        }
        //if sub tree has only left node in that case consider depth of left tree +1.
        else if(leftnode!=null && rightnode==null){
            return 1+minDepth(leftnode);
        }
        //if both the nodes are not null in that case consider 1+ min of leftdepth, rightdepth
        else{
            return 1+Math.min(minDepth(leftnode),minDepth(rightnode));
        }
    }
}