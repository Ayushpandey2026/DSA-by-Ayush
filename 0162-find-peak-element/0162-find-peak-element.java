class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low=0,high=n-1; int var=0;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]<nums[mid+1]) low=mid+1;
            else{
                    high=mid;
                }
        }
        return low;
    }
}