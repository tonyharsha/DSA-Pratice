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
    public ListNode deleteDuplicates(ListNode head) {
        //Create two nodes AnsHead and AnsTail inilize it to null.
        ListNode temp=head;

        ListNode AnsHead=null;
        ListNode AnsTail=null;

        while(temp!=null){
            //using two pointer approach.
            //adding the value/Node to Ans list only if the value is repeated once.

            ListNode i=temp;
            ListNode j=temp;
            int freq=0;

            while(j!=null && i.val==j.val){
                freq++;
                j=j.next;
            }

            if(freq==1){
                if(AnsHead==null && AnsTail==null){
                    AnsHead=temp;
                    AnsTail=temp;
                }else{
                    AnsTail.next=temp;
                    AnsTail=temp;
                }
            }
            //Since j is moved to the next Node till it finds diff Node val from i so we
            //are updating j value to temp.
            temp=j;
        }

        // This condition is imp to handle few edge cases.
        //In case like elemnts are repeated ant end of list.
        //AnsTail will be pointing to last unique node.
        if(AnsTail!=null){
            AnsTail.next=null;
        }

        return AnsHead;
    }
}