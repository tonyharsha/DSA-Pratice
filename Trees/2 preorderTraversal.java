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
 
 //TC O(H)
 //SC Recursion stcak.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorder(res,root);
        return res;  
    }

    public void preorder(List<Integer> res,TreeNode root){
        if(root!=null){
            res.add(root.val);
            preorder(res,root.left);
            preorder(res,root.right);
        }
    }
}



//TC O(H)
//SC O(N)
//The mai idea is.
//Traverse to left most node and add it res and stack in the process.
//Now pop and point the curr node to right of poped node.
//exist from code when stack is empty.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode cur=root;
        while(true){
            if(cur!=null){
                res.add(cur.val);
                st.add(cur);
                cur=cur.left;
            }else{
                if(st.isEmpty()) break;
                cur=st.pop().right;
            }
        }
        return res;
        
    }
}