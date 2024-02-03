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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<Integer> path=new ArrayList<>();
       pathSum(path,root,targetSum); 
       return res;
    }

    public void pathSum(List<Integer> path,TreeNode root,int targetSum){
        if(root==null) return;
        

        path.add(root.val);
        //targetSumm must be equal to zero and the current node should be leaf node..
        if(root.left==null && root.right==null && root.val-targetSum==0){
            res.add(new ArrayList<>(path));
        }

            pathSum(path,root.left,targetSum-root.val);
            pathSum(path,root.right,targetSum-root.val);
        //Backtracking..
        path.remove(path.size()-1);
    }
}
