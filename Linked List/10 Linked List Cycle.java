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
    public boolean hasCycle(ListNode head) {
		
		//Method 1. and prefer this.
		if(head==null|| head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        
        //slow and fast pointer technique.
        //If Cycle exists then both slow and fast will meet for sure.
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }

        return false;
		
		
		//Method 2.
        if(head==null|| head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head.next;
        
        //slow and fast pointer technique.
        //If Cycle exists then both slow and fast will meet for sure.
        while(slow!=null && fast!=null){
            if(slow==fast) return true;
            slow=slow.next;
            fast=(fast.next==null)?null:fast.next.next;
        }

        return false;
        
    }
}