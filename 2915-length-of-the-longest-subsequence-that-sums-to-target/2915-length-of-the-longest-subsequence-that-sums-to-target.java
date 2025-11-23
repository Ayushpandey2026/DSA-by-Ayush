class Solution {
    public int longest(int i, List<Integer> list,int sum, int target,int[][] dp){
         if(sum==target) return 0;
        if(i==list.size() || sum > target) return -100000000;
       if(dp[i][sum]!=-1) return dp[i][sum];

      int skip =  longest(i+1,list,sum,target,dp);
      int pick = 1 + longest(i+1,list,sum+list.get(i),target,dp);
       return dp[i][sum]=  Math.max(skip,pick); 
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans =  longest(0,nums,0,target,dp);
         return ans < 0 ? -1 : ans;
    }
}