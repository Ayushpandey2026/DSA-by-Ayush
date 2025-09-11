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
     public ListNode reverse(ListNode head) {
        ListNode prev =null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next=prev;
            prev=temp;
            temp =front;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevtail = dummy;

        ListNode temp=head; int l=0;
       
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        temp=head;

        while(l>=k){
            ListNode ghead=prevtail.next;
            ListNode gend=prevtail;
            for(int i=0;i<k;i++){
                gend=gend.next;
            }
            ListNode nextghead = gend.next;
            gend.next=null;
            ListNode rev = reverse(ghead);

            prevtail.next= rev;
           ghead.next= nextghead;
           prevtail=ghead;
           l -=k;
        }
       return dummy.next;
    }
}