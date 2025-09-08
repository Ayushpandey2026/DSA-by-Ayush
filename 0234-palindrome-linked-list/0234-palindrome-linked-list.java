
class Solution {
    public ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode temp =node;
        while(temp!=null){
           ListNode front = temp.next;
            temp.next=prev;
            prev=temp;
            temp =front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode t1=reverse(slow);
        ListNode temp=head; 
        while(t1!=null){
            if(t1.val!=temp.val) return false;
            t1=t1.next;
            temp=temp.next;
        }
        return true;
    }
}