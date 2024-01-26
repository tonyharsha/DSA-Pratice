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
//Very Imp Here we are using the height but not returning the height.
//diameter is like left length+ right length.
//perform the height of the tree mean while calculate the diameter also.
class Solution {
    int diameter=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    public int getHeight(TreeNode root){
        if(root==null) return 0;
        int leftheight=getHeight(root.left);
        int rightheight=getHeight(root.right);
        diameter=Math.max(diameter,leftheight+rightheight);
        return 1+Math.max(leftheight,rightheight);
    }
}