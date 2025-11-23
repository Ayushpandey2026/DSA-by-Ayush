class Solution {
    public int ways(int i, int[] nums, int target,int sum){
         if(i==nums.length){
        if(sum==target) {
            return 1;
        }
        else return 0;
         }

     int add =  ways(i+1,nums,target,sum - nums[i]);
     int sub  =  ways(i+1,nums,target,sum + nums[i]);
     return add+sub;

    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0,nums,target,0);
    }
}