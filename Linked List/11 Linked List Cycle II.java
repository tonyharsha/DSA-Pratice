/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null) return null;

        //Main Concept is detect the loop via slow and fast pointer approach.
        //If loop exists then move slow pointer to head and
        //Now compare slow and fast via moving one step and for sure they will meet at cycle begin point.
        //else return null.

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                //loop detected..
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
            
        }

        return null;
        
    }
}