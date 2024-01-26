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
    //Same logic used for level order traversal of binary tree.
    //Using flag for zigzag traversal..
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null){
            q.add(root);
        }
        boolean flag=false;
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> lvl=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                lvl.add(q.peek().val);
                q.remove();
            }
            flag=!flag;
            if(flag==false){
                Collections.reverse(lvl);
            }
            res.add(lvl);
            

        }
        return res;
    }
}