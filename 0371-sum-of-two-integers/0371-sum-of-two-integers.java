class Solution {
    public int getSum(int a, int b) {
       while(b!=0){
        int carry = (a & b) << 1; 
        a = a ^ b; // for sum
        b= carry;
       }
       return a;
    }
    
}