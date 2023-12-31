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
    public ListNode removeElements(ListNode head, int val) {
//checking if head is null..
        if(head==null){
            return head;
        }
//checking if head value is equal to val..
        while(head!=null && head.val==val){
            head=head.next;
        }
//Having two node prev and current..
        ListNode prev=null;
        ListNode cur=head;
//Main logic for deletion.
        while(cur!=null){
            if(cur.val==val&&prev!=null){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            } 
        }
        return head;
        
    }
}