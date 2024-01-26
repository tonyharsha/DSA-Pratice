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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            double sum=0;
            for(int i=0;i<n;i++){
                if(q.peek().left!=null)
                  q.add(q.peek().left);
                if(q.peek().right!=null)
                  q.add(q.peek().right);
                sum+=q.peek().val;
                q.remove();
            }
            res.add(sum/n);
        }
        return res;
    }
}