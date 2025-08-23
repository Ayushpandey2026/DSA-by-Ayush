class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 1;
        Arrays.sort(nums); int cnt=1;
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1 == nums[i]) {
                cnt++;
                max = Math.max(max,cnt);
            }
            else if(nums[i-1] == nums[i]) continue;
           else{
             max = Math.max(max,cnt);
             cnt=1;
           }
        }
        return max;
    }
}