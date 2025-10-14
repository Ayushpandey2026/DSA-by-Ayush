class Solution {
      private void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
            ans.add(new ArrayList<>(curr));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
        curr.add(nums[i]);
        helper(i+1,nums,curr,ans);
        curr.remove(curr.size()-1);
        }
      }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>();
                helper(0,nums,new ArrayList<>(),ans);
                return ans;

    }
}