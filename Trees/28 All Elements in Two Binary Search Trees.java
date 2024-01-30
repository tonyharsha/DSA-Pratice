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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //We have two ways
        //Any order traversal add all the elemnts to list and sort and return
        //Flattern the bst and then then merge the lists and copy the output and return
        List<Integer> res=new ArrayList<>();
        inorder(root1,res);
        inorder(root2,res);
        Collections.sort(res);
        return res;
    }

    public void inorder(TreeNode root,List<Integer> res){
        if(root!=null){
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }
    }
}