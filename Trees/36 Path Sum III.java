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
 //TC O(N^2)
 //SC O(logN) Recursion Stack
class Solution {
    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root!=null){
            helper(root,targetSum);
            pathSum(root.left,targetSum);
            pathSum(root.right,targetSum);
        }
        return res;
    }

    public void helper(TreeNode root,long targetSum){
        if(root!=null){
            if(targetSum==root.val) res++;
            helper(root.left,targetSum-root.val);
            helper(root.right,targetSum-root.val);
        }
    }
}

