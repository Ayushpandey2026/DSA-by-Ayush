class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos = new int[n/2];
         int[] neg = new int[n/2]; int k=0,j=0;

         for(int i=0;i<n;i++){
            if(nums[i]>0) pos[j++]=nums[i];
            else neg[k++]=nums[i];
         }

            k=0;
         for(int i=0;i<n/2;i++){
            nums[k++]=pos[i];
            nums[k++]=neg[i];
         }
         return nums;
    }
}