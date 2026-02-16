public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i=0, j=31; 
        while(i<j){
            int imask=(1<<i), jmask=(1<<j);
            boolean ion = ((n&imask)!=0), jon = ((n&jmask)!=0);
            if(ion!=jon){
                n ^=imask;
                n ^=jmask;
            }
           i++;
           j--;
        }
        return n;
    }
}