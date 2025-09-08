
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
    public ListNode cloneList(ListNode node){
        if(node==null) return null;
        ListNode newhead = new ListNode(node.val);
        ListNode currnew = newhead;
        ListNode currold = node.next;
        while(currold!=null){
            currnew.next = new ListNode(currold.val);
            currnew =currnew.next;
            currold=currold.next;
        }
        return newhead;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode clone=cloneList(head);
        ListNode t1=reverse(clone);
        while(temp!=null && t1!=null){
            if(temp.val!=t1.val) return false;
            temp=temp.next;
            t1=t1.next;
        }
        return true;
    }
}