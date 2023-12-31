/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //Find the Middle Node.
        //Rverse the Linked List from middle node to end and get the end node.
        //Now compare the values of actual head and the reversed list
        ListNode MiddleNode=Middle(head);
        ListNode LastNode=Reverse(MiddleNode);
        while(head!=null && LastNode!=null){
            if(head.val!=LastNode.val) return false;
            head=head.next;
            LastNode=LastNode.next;
        }

        return true;


        
    }


    public ListNode Middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode Reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
          ListNode temp=curr.next;
          curr.next=prev;
          prev=curr;
          curr=temp;  
        }
        return prev;
    }
}