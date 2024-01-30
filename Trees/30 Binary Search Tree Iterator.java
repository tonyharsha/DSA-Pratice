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
class BSTIterator {
    ArrayList<Integer> res;
    int itr=0;
    public BSTIterator(TreeNode root) {
        res=new ArrayList<>();
        inorder(root);
    }
    
    public int next() {
        return res.get(itr++);
    }
    
    public boolean hasNext() {
        return (itr==res.size())?false:true;
    }

    public void inorder(TreeNode root){
        if(root!=null){
           inorder(root.left);
           res.add(root.val);
           inorder(root.right); 
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */