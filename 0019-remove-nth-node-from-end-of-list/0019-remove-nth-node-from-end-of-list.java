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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null ) return null;
        ListNode temp=head; int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
         if (n == cnt) {
            return head.next;
        }
        temp=head;
        ListNode prev = head;
        for(int i=1;i<cnt-n;i++){
            temp=temp.next;
        }

      if(temp.next!=null){
        temp.next=temp.next.next;
      }
        return head;
    }
}