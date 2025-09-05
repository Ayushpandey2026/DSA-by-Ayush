class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n =nums.length; int sum=0;
        int max=0; int high=0; int low=1;
          for (int num : nums) high = Math.max(high, num);
          int ans= high;
          while(low<=high){
            int mid = low + (high - low) / 2;
            sum=0;
            for(int j=0;j<n;j++){
             sum += (nums[j] + mid - 1) / mid; 
            }
            if(sum<=threshold){
            ans = mid;
            high=mid-1;
            }
            else{
                low=mid+1;
            }
          }
        return ans;
    }
}