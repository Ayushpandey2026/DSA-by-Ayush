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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
         int cnt=1;
    
        while(slow.next!=null){
            cnt++;
            slow=slow.next;
        }
       k = k % cnt;
        if (k == 0) return head;

        ListNode temp=head;
        for(int i=1;i<cnt-k;i++){
            temp=temp.next;
        }
        ListNode newnode=temp.next;
        temp.next=null;
        slow.next=head;
        
        return newnode;

    }
}