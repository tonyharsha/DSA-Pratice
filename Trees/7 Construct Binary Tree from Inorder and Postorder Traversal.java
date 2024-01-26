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

//Method 1.
//this is very simple.
//Store the inorder array elements and their indices in hashmap.
//Since it is postorder root will be in end of the array.
//So traverse from end to begin.
//and first built the right sub tree and then build the left sub tree.
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        int start=0;
        int index=inorder.length-1;
        int end=inorder.length-1;;

        return buildTree(postorder,index,start,end,hm);
    }

    public TreeNode buildTree(int postorder[],int index,int start,int end,HashMap<Integer,Integer> hm){
        if(start>end) return null;

        TreeNode node=new TreeNode(postorder[index]);
        int position=hm.get(postorder[index]);

        if(start==end) return node;

        node.right=buildTree(postorder,index-1,position+1,end,hm);
       
       //VVIMP Here already right sub tree is build so we need to calculate the index need to
       //send for building of left sub tree.
        int rightsubtreelength=end-position;
        node.left=buildTree(postorder,index-rightsubtreelength-1,start,position-1,hm);
        return node;
    }
}



//Method 2
class Solution {
     HashMap<Integer,Integer> hm=new HashMap<>();
     int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        index=postorder.length-1;
        int start=0;
        int end=postorder.length-1;
        
        return BuiltTree(postorder,0,end);
    }

    public TreeNode BuiltTree(int[] postorder,int start,int end){

        if(start>end) return null;

        TreeNode node=new TreeNode(postorder[index]);
        int position=hm.get(postorder[index]);
        index--;

        if(start==end) return node;

        
        node.right=BuiltTree(postorder,position+1,end);
        node.left=BuiltTree(postorder,start,position-1);
        return node;
    }
}
