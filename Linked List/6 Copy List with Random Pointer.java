/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
	     
        //TC O(n) space..
		if(head==null) return head;
        HashMap<Node,Node> hm=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            hm.put(temp,new Node(temp.val)); 
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node newNode=hm.get(temp);
            newNode.next=hm.get(temp.next);
            newNode.random=hm.get(temp.random);
            temp=temp.next;
        }
        return hm.get(head);
        
        //Without using extra space
        //TC O(1)
       //base condition 
        if(head==null){
            return head;
        }
        //creating an temp node for each actual node such that actual.next=temp and temp.next=actual.next
        Node temp=head;
        while(temp!=null){
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=newNode.next;
        }

        //now pointing temp node random pointer with hep of actual node.

        temp=head;
        while(temp!=null && temp.next!=null){
            //This line is imp because to handle edge case when node random pointer points to null
            temp.next.random=(temp.random!=null)?temp.random.next:null;
            temp=temp.next.next;
        }

        //Now seperating the actual and temp linked list..
        temp=head;
        Node newNode=temp.next;
        Node res=temp.next;
        while(temp!=null){
            temp.next=temp.next.next;
            //This to handle the last element in temp linkedlist [to overcome null error]
            newNode.next=(newNode.next!=null)?newNode.next.next:newNode.next;

            temp=temp.next;
            newNode=newNode.next;
        }
        return res;


        
    }
}