class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
       map.put(0,1);
       int presum =0;
       int cnt=0;

       for(int num : nums){
            presum += num;
            if(map.containsKey(presum - k)){
                cnt += map.get(presum - k);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);
       }
        return cnt;
    }
}