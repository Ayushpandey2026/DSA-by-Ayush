class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[2];
        HashMap<Integer,Integer> map= new HashMap<>(); 
      for(int i =0;i<nums.length;i++){
       int val = target - nums[i];
       if(map.containsKey(val)){
            arr[0]=i;
            arr[1]=map.get(val);
             break;
        }
        else map.put(nums[i],i);
      }  
      return arr;
    }
}