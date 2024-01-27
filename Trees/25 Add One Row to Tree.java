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

//Iterative
//TC O(N)
//SC O(N)
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val,root,null);
            return node;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=1;

        while(!q.isEmpty()){
            int size=q.size();
           
            for(int i=0;i<size;i++){
                //Since there exists a case where we need to insert at last row so we are removing 
                //element first and then processing.
                TreeNode cur=q.remove();
                if(count==depth-1){
                    cur.left=new TreeNode(val,cur.left,null);
                    cur.right=new TreeNode(val,null,cur.right);
                }
                else{
                    if(cur.left!=null) q.offer(cur.left);
                    if(cur.right!=null) q.offer(cur.right);
                }  
            }
             count++;
        }
        return root;   
        
    }
}


//Recursive
//TC O(N)
//SC Recursion stack.
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return null;
        if(depth==1)
           root= new TreeNode(val,root,null);
        else if(depth==2){
           root.left=new TreeNode(val,root.left,null);
           root.right=new TreeNode(val,null,root.right);   
        }else{
            addOneRow(root.left,val,depth-1);
            addOneRow(root.right,val,depth-1);
        }

        return root;

           
    }
}