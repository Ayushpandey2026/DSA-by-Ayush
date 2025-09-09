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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        ListNode dummy = new ListNode(100);  
        ListNode temp = dummy;
        ListNode a=l1;
        ListNode b =l2;
        int carry=0;
        while(a!=null && b!=null){
            int sum =( a.val+b.val+carry);
            int val=sum%10;
             carry=sum/10;
            temp.next=new ListNode(val);
            temp=temp.next;
            a=a.next;
            b=b.next;
        }
        while(a!=null){
            int sum =( a.val+carry);
            int val=sum%10;
             carry=sum/10;
            temp.next=new ListNode(val);
            temp=temp.next;
            a=a.next;
        }
         while(b!=null){
           int sum =( b.val+carry);
            int val=sum%10;
             carry=sum/10;
            temp.next=new ListNode(val);
            temp=temp.next;
            b=b.next;
        }
       if(carry>0) temp.next=new ListNode(carry);
        return dummy.next;
    }
}