/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        //On finding the value return the value.
        if(root.val==p.val||root.val==q.val) return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);


        //imp logic 
        if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        else if (left!=null && right !=null)return root;
        else return null;
    }
}