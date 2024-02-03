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
 
//TC O(N)
//SC Recursion Stack.
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(targetSum-root.val==0 && root.left==null && root.right==null) return true;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}



class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root,targetSum,0);
    }

    public boolean hasPathSum(TreeNode root,int targetSum,int runningSum){
        boolean left=false;
        boolean right=false;
        if(root!=null){
            runningSum+=root.val;
            if(runningSum==targetSum && root.left==null && root.right==null) return true;
            left=hasPathSum(root.left,targetSum,runningSum);
            right=hasPathSum(root.right,targetSum,runningSum);
        }
        return left||right;
    }
}
