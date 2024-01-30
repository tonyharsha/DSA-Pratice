/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/


//TC O(N+M) 
//SC O(N+M)
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer>res1=new ArrayList<>();
        List<Integer>res2=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        inorder(root1,res1);
        inorder(root2,res2);
        
        int n=res1.size();
        int m=res2.size();
        
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(res1.get(i)>res2.get(j)){
                res.add(res2.get(j));
                j++;
            }else{
                res.add(res1.get(i));
                i++;
            }
        }
        
        while(i<n){
            res.add(res1.get(i));
            i++;
        }
        
        while(j<m){
            res.add(res2.get(j));
            j++;
        }
        
        return res;
        
        
    }
    
    public void inorder(Node root,List<Integer> output){
        if(root!=null){
            inorder(root.left,output);
            output.add(root.data);
            inorder(root.right,output);
        }
    }
}



//TC O(M+N)
//SC O(1)
//The steps are flatten the binary search tree to linked list
//Now merge these two lists without extra space.
class Solution
{
    Node prev=null;
    public Node merge(Node root1,Node root2)
    {
        Node list1=FlatternTree(root1);
        //Since we are freshly calling FlatternTree we are flusing the prev value.
        prev=null;
        Node list2=FlatternTree(root2);
        
        //Merge the lists without extra space.
        
        Node dummy=new Node(-1);
        Node temp=dummy;
        
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                temp.right=list1;
                temp=list1;
                list1=list1.right;
            }else{
                temp.right=list2;
                temp=list2;
                list2=list2.right;
            }
        }
        
        while(list1!=null){
            temp.right=list1;
            temp=list1;
            list1=list1.right;
        }
        
        while(list2!=null){
            temp.right=list2;
            temp=list2;
            list2=list2.right;
        }
        
        return dummy.right;
        
    }
    
    public Node FlatternTree(Node root){
        if(root!=null){
            FlatternTree(root.right);
            FlatternTree(root.left);
            root.right=prev;
            root.left=null;
            root=prev;
        }
        return root;
    }
}