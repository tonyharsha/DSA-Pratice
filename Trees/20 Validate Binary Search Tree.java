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
  // Main logic is we should use range to comapare whether it is BST or not.
 //Long..MIN_VALUE Long.MAX_VAUE

/*
      5
 1         4
       3        6

       exclusive min and max.
       For 5 range is min-max
       For 1 range is min-5   => greater than min and less than 5
       For 4 range is 5-max   => since it doesnt satistify the range it is not BST. 


      5
 1         7
        6      8

       exclusive min and max.
       For 5 range is min-max
       For 1 range is min-5   => greater than min and less than 5
       For 7 range is 5-max  
       For 6 range is 5-7
       For 8 range is 7-max..
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        Long min=Long.MIN_VALUE;
        Long max=Long.MAX_VALUE;
        return isValidBST(root,min,max);
    }

    public boolean isValidBST(TreeNode root, long min,long max){
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
        
    }
}