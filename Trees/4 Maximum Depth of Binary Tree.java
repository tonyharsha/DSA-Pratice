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
//Recursive.
//TC O(H)
//SC Recursion stack.

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
        
    }
}


//Iterative
//TC O(N)
//SC O(N)
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null) q.offer(root);
        int Depth=0;
        while(!q.isEmpty()){
            int n=q.size();
            Depth++;
            for(int i=0;i<n;i++){
                TreeNode element=q.poll();
                if(element.left!=null) q.offer(element.left);
                if(element.right!=null) q.offer(element.right);
            }
        }
        return Depth;
        
    }
}