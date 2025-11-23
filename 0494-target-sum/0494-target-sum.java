class Solution {
    static int res =0;
    public int ways(int i, int[] nums, int target,int sum,int[][] dp){
         if(i==nums.length){
        if(sum==target) return 1;
        else return 0;
         }
     if(dp[i][res+sum]!=-1) return dp[i][res+sum];
     int sub =  ways(i+1,nums,target,sum - nums[i],dp);
     int add  =  ways(i+1,nums,target,sum + nums[i],dp);
     return dp[i][res+sum]= add+sub;

    }
    public int findTargetSumWays(int[] nums, int target) {
        res =0;
        for(int i=0;i<nums.length;i++) res+=nums[i];
        int[][] dp=new int[nums.length][2*res+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return ways(0,nums,target,0,dp);
    }
}