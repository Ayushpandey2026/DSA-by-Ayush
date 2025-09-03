class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length; int first=-1,last=-1;
        int low =0, high = n-1, mid=0;
        while(low<=high){
            mid = low + (high - low) / 2;
            if(nums[mid]>=target){
                if(nums[mid]==target)  first=mid;
                    high = mid-1;
            }
            else low = mid + 1;
        }

          low =0; high = n-1; mid=0;
        while(low<=high){
           mid = low + (high - low) / 2;
            if(nums[mid]<=target){
                if(nums[mid]==target) last=mid;
                low = mid+1;       
            }
            else high = mid - 1;
        }

        return new int[] {first,last};
    }
}