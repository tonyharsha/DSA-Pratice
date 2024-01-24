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
 
 //Recursive
 //TC O(H)
 //SC Recurstion stack.
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorder(res,root);
        return res;
    }

    public void postorder(List<Integer> res, TreeNode root){
        if(root!=null){
            postorder(res,root.left);
            postorder(res,root.right);
            res.add(root.val);
        }
    } 
}


//Iterative
//TC O(H)
//Sc O(N)

//This is very simple and need to use Two stacks.
//put root in stack1 and then pop it from stack1 and add to stack2.
//Now add the stack2 peek element left and right to stack1
//repeat the process till stack1 is empty.

//we are following LR because Node is down in stack and we need to process the right first then left
// so since stack is LIFO insertin left first snd then inserting right.
// stack2 contains right left node.
// while poping it follows this sequence RLN.
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();

        TreeNode cur=root;
 
       if(root!=null){
           st.push(root);
       }
        while(!st.isEmpty()){
                st2.push(st.pop());
                if(st2.peek().left!=null)
                   st.push(st2.peek().left);
                if(st2.peek().right!=null)
                   st.push(st2.peek().right);
        }
        
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }

        return res;

    }
}