class Solution {
    public int[] twoSum(int[] nums, int target) {
        int m = nums.length;
        int[] sec = {-1, -1}; 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                sec[0] =i;
                sec[1] = map.get(val);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return sec;
    }
}