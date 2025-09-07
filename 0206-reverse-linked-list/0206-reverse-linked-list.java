
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp=head;
        Stack<Integer> st = new Stack<>();
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null && !st.isEmpty()){
            temp.val=st.pop();
            temp=temp.next;

        }
        return head;
    }
}