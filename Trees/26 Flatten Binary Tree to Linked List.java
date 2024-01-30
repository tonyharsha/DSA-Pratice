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
 //The Main idea is we should process the rightmost element first then left elemt and the root.
class Solution {
    //IMP 
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        postorder(root);
    }

    public void postorder(TreeNode root){
        if(root!=null){
            postorder(root.right);
            postorder(root.left);
            root.right=prev;
            root.left=null;
            prev=root;
        }
    }
}