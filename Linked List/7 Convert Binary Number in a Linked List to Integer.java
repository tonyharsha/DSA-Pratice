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
    public int getDecimalValue(ListNode head) {
        if(head==null) return 0;
        StringBuilder sb=new StringBuilder();
        ListNode temp=head;
        while(temp!=null){
            sb.append(temp.val);
            temp=temp.next;
        }
        
		//Process A.
		String rev=sb.reverse().toString();
        int result=0;
        int base=0;
        for(int i=0;i<rev.length();i++){
            //48 is ascii value of 0.
            result+=(Math.pow(2,base)*(rev.charAt(i)-48));
            base++;
        }
        return result;
        
		
		//Process B.
		//This line literally does magic converts the binary no with given base..
        int x=Integer.parseInt(sb.toString(),2);
        return x;
        
    }
}