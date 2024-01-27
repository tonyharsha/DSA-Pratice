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


//Method 1 Not Working need to work on it.
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }

        int start=0;
        int end=preorder.length-1;
        int index=0;

        return constructFromPrePost(preorder,start,end,index,hm);

    }

    public TreeNode constructFromPrePost(int []preorder,int start,int end,int index,HashMap<Integer,Integer> hm){
        if(start>end) return null;

        TreeNode node =new TreeNode(preorder[index]);
        int position=hm.get(node.val);
        if(start==end) return node;

        node.left=constructFromPrePost(preorder,start,position-1,index+1,hm);
        if(node.left!=null)
           start=hm.get(node.left.val);
        node.right=constructFromPrePost(preorder,start+1,position-1,index+(position-start),hm);
        return node;
    }
}




//Method 2
//Working fine.
// The generated tree might not be unique since it build from preorder and postorder.
class Solution {
    int index=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }

        int start=0;
        int end=preorder.length-1;

        return constructFromPrePost(preorder,start,end,hm);

    }

    public TreeNode constructFromPrePost(int []preorder,int start,int end,HashMap<Integer,Integer> hm){
        if(start>end) return null;

        TreeNode node =new TreeNode(preorder[index++]);
        int position=hm.get(node.val);
        if(start==end) return node;

        node.left=constructFromPrePost(preorder,start,position-1,hm);
        if(node.left!=null)
           start=hm.get(node.left.val);
        node.right=constructFromPrePost(preorder,start+1,position-1,hm);
        return node;
    }
}
