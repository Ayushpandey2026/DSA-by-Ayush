class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> arr = new ArrayList<>(); int a=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else arr.add(nums[i]);
        }
        arr.add(nums[nums.length-1]);
        for(int i=0;i<arr.size();i++){
            nums[i] =arr.get(i);
        }
        return arr.size();

    }
}