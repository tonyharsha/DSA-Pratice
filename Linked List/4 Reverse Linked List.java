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
    public ListNode reverseList(ListNode head) {
        
        //Iterative
        if(head==null) return head;
        ListNode Curr=head;
        ListNode prev=null;

        while(Curr!=null){
            ListNode temp=Curr.next;
            Curr.next=prev;
            prev=Curr;
            Curr=temp;
        }

        return prev;
        

        //Recursive.
        ListNode Curr=head;
        ListNode prev=null;

        return RecurvList(Curr,prev);
        
    }

    public ListNode RecurvList(ListNode Curr,ListNode prev){
        if(Curr==null) return prev;
        ListNode temp=Curr.next;
        Curr.next=prev;
        prev=Curr;
        Curr=temp;
        return RecurvList(Curr,prev);
    }
}