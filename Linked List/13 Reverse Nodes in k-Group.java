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
    //TC O(2N)~O(N)
    //SC O(1).
    //The Main logic is
    //-> Find Kth Node.
    //-> Reverse the Linked List of K nodes.
    //-> Take care of Connections like first node should connect with 6th node on reversal of both if K=3.
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp=head;
        ListNode prevNode=null;
        ListNode nextNode=null;


        while(temp!=null){
            //getting the Kth Node.
            ListNode kthNode=getKthNode(temp,k);
            if(kthNode==null){
                //Imp condition if Nodes are less than K.
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            

            nextNode=kthNode.next;
            //Cut the link and pass it to reverse 
            kthNode.next=null;

            //Reversal happened.
            ListNode reverseHead=Reverse(temp);

            //For first reversal we need to change head.
            //From Second one take care of connections.
            if(head==temp){
                head=reverseHead;
            }else{
                prevNode.next=reverseHead;
            }

            //storing prevNode so we can link to new head from next k nodes.
            prevNode=temp;
            temp=nextNode;
        }

       return head;
        
    }

    public ListNode getKthNode(ListNode head,int k){
        ListNode temp=head;
        k--;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }

    public ListNode Reverse(ListNode head){
        ListNode prev=null;
        ListNode Curr=head;
        while(Curr!=null){
            ListNode temp=Curr.next;
            Curr.next=prev;
            prev=Curr;
            Curr=temp;
        }
        return prev;
    }
}