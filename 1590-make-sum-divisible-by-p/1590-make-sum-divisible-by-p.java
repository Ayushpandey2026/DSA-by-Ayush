class Solution {
    public int minSubarray(int[] nums, int p) {
       int total = 0;
        for (int x : nums) total = (total + x) % p;

        int r = total % p;
        if (r == 0) return 0;

        int prefix = 0;
        int ans = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  

          for (int i = 0; i < nums.length; i++) {
            prefix =(prefix + nums[i])%p;
           int  target =(prefix-r+p)%p;

            if(map.containsKey(target)){
                ans =Math.min(ans,i-map.get(target));
            }
            map.put(prefix,i);
          }

        return ans == nums.length ? -1 : ans;
    }
}