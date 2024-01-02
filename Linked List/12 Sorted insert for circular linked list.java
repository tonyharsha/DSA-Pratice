/*
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}
*/

class Solution {
	public SinglyLinkedListNode insert(SinglyLinkedListNode head, int key) {
		// Your code goes here

        SinglyLinkedListNode curr=head.next;
        SinglyLinkedListNode prev=head;
      while(curr!=head){
            if((key>=prev.data && key<=curr.data) || (key>prev.data && curr.data<prev.data)||
            (key<curr.data && curr.data<prev.data) ){
                 break;
            }
            prev=prev.next;
            curr=curr.next;
        }
         SinglyLinkedListNode newNode=new SinglyLinkedListNode(key);
        prev.next=newNode;
        newNode.next=curr;
        
        return head;
	}
}