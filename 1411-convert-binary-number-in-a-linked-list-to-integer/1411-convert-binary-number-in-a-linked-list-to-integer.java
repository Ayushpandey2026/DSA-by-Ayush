
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        int[] arr = new int[30];
        int i=0;
       while( i< arr.length && temp!=null){
        arr[i++] = temp.val;
        temp=temp.next;
       } 
       int sum=0;
        int k=i-1;
       for(int j=0;j<i;j++){
           sum+=arr[j]*Math.pow(2,k--);
       }
       return sum;
    }
}