class Solution {
    public int nextGreaterElement(int n) {
        char[] digits =String.valueOf(n).toCharArray();
        int len=digits.length;

        int i=len-2;
        while(i>=0 && digits[i]>=digits[i+1]){
            i--;
        }
        if(i==-1) return -1;

        int j=len-1;
        while(digits[j]<=digits[i]){
            j--;
        }

        swap(digits,i,j);

        reverse(digits,i+1,len-1);

        try {
            long val = Long.parseLong(new String(digits));
            return (val > Integer.MAX_VALUE) ? -1 : (int) val;
        } catch (Exception e) {
            return -1;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start++, end--);
        }
    }

}