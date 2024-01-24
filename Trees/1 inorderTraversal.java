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
// Recursive code 
//TC O(H)
//SC Recursion stack.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(res,root);
        return res;
    }

    public void inorder(List<Integer> res,TreeNode root){
        if(root!=null){
            inorder(res,root.left);
            res.add(root.val);
            inorder(res,root.right);
        }
    }
}



//Iterative 
//TC O(H)
//SC O(N)
//The main idea is 
//-> Traverse to left end node and add to stack in the process.
//-> on reaching the null node add the peek node.val to result and pop from stack and point the curr to its right.
//-> Repeat the process and exist when stack is empty.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode cur=root;
        while(true){
            if(cur!=null){
                st.add(cur);
                cur=cur.left;
            }else{
                if(st.isEmpty()) break;
                res.add(st.peek().val);
                cur=st.pop().right;
            }
        }
        return res;
    }
}