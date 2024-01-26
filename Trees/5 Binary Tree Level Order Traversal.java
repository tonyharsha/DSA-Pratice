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

  //The approach is simple
 //add the root node to queue.
 //add its children to queue once its children added then remove the element from the queue.
 //loop through level 1 nodes assume 2 nodes present
 //so add the childs of node 1 remove node 1
 //next add the child of node 2 remove node 2
 //now the q consists of all the elemnts on level 2 
 // repeat the same..
 //TC O(N)
 //SC O(N).
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root!=null) q.offer(root);

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> subresult=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(q.peek().left!=null)
                   q.offer(q.peek().left);
                if(q.peek().right!=null)
                   q.offer(q.peek().right);
                subresult.add(q.peek().val);
                q.remove();
            }
            result.add(subresult);
        }

        return result;
    }
}