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
//SC O(N) + recurtion stack
class Solution {
   ArrayList<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        kthSmallest(root);
        return res.get(k-1);
    }

    public void kthSmallest(TreeNode root){
        if(root==null) return;
        kthSmallest(root.left);
        res.add(root.val);
        kthSmallest(root.right);
    }
}


//TC O(N)
//SC O(1)+Recurtion stack
class Solution {
    //inorder traversal of binary search tree will give ua an sorted array.
    //so the logic is to find the k smallest element via inorder traversal
    //count will be zero when control goes to new node increase the count
    //if count==k then return that root.val
    int res=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }

    public void inorder(TreeNode root, int k){
        if(root!=null){
            inorder(root.left,k);
            count++;
            if(k==count){
                res=root.val;
                return ;
            }
            inorder(root.right,k);
        }
    }
}