class Solution {
    private void combine(int i,int[] nums,int target,List<List<Integer>> ans,List<Integer> list){
        int n = nums.length;

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
          for(int a=i;a<n;a++){
            if(a>i && nums[a]==nums[a-1]) continue;
            if(target<nums[a]) break;

            list.add(nums[a]);
            combine(a+1,nums,target-nums[a],ans,list);
            list.remove(list.size()-1);

    }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
          Arrays.sort(candidates);
        combine(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}