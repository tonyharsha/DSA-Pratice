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
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null) return head;
 
        ListNode Dummy=new ListNode(0);
        Dummy.next=head;
        ListNode Node=Dummy;

        
        ListNode first=Node.next;
        ListNode second=Node.next.next;
        while(first!=null && second!=null){
            //swapping the nodes
            first.next=second.next;
            second.next=first;
             
            //preparing for next swap. 
            Node.next=second;
            Node=first;
            
            //next first and second pointers
            first=Node.next;
            second=(Node.next==null)?null:Node.next.next;
        }
        return Dummy.next;
      
    }
}