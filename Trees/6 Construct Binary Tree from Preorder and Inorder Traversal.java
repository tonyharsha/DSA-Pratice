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
//Approach is simple.
    //-> store the inorder array element and index of element in HashMap.
    //-> now add the first element in preorder.
    //-> now search the index of that element in hashmap so elements left to the index in inorder are left side
    // and elements right to the index are right elemnets.
    //-> This repeates recursivily. 


//Method 1
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        int start=0;
        int end=preorder.length-1;
        int index=0;

        return buildTree(preorder,start,end,index,hm);
    }

    public TreeNode buildTree(int [] preorder,int start, int end,int index,HashMap<Integer,Integer> hm){
        if(start>end) return null;

        TreeNode node=new TreeNode(preorder[index]);
        if(start==end) return node;
        int position=hm.get(node.val);

        node.left=buildTree(preorder,start,position-1,index+1,hm);
        
		//VVimp 
		//Since left is already build now we need to build right tree and index will be index+length of left sub tree+1.
        int leftsubtreelength=position-start;

        node.right=buildTree(preorder,position+1,end,index+leftsubtreelength+1,hm);

        return node;
    }
}

//Method 2
class Solution {
    int index=0;
    HashMap<Integer,Integer> hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1);
    }

    public TreeNode buildTree(int [] preorder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode node=new TreeNode(preorder[index]);
        index++;

        if(start==end){
            return node;
        }
        int position=hm.get(node.val);
        node.left=buildTree(preorder,start,position-1);
        node.right=buildTree(preorder,position+1,end);
        return node;
    }
}
