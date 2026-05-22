class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int[] arr={-1,-1};
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }
            else{
                int key= map.get(target-nums[i]);
                arr[0]=key;
                arr[1]=i;
                return arr;

            }
        }
        return arr;
    }
}