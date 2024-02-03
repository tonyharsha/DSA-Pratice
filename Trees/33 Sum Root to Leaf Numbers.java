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
 //SC Recursion stack.
class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        preorder(root,0);
        return sum;
    }

    public void preorder(TreeNode root,int runningSum){
        if(root!=null){
            //irrespect of traversal logic remains same.
             runningSum=runningSum*10;
             runningSum+=root.val;
             if(root.left==null && root.right==null)
                sum+=runningSum;
             preorder(root.left,runningSum);
             preorder(root.right,runningSum);
        }
    }
}
