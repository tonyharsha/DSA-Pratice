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
 //SC O(N)
class Solution {
    HashSet<Integer> hs=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        boolean left=false;
        boolean right=false;
        if(root!=null){
            left=findTarget(root.left,k);
            //IMP
            if(hs.contains(k-root.val)) return true;
            hs.add(root.val);
            right=findTarget(root.right,k);
        }
        return left||right;
        
    }
}