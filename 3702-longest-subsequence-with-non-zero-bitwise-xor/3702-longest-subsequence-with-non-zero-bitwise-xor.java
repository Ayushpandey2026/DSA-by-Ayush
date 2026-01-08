class Solution {
    public int longestSubsequence(int[] nums) {
        int xor =0; int cnt=0;
        int n=nums.length;
        boolean zero=true;
        for(int ele : nums){
            xor ^=ele;
            if(ele!=0) zero=false;
        }
        if(zero) return 0;
        return xor !=0 ? n  :n-1;

    }
}