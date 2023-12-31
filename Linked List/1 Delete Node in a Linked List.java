/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //storing the value of next node in current node.
        node.val=node.next.val;
        //changing the link from next node to next-next node.
        //once is link is disabled it means deleted.
        node.next=node.next.next;
    }
}