class Solution {
    private void combine(int i,int[] nums,int target,List<List<Integer>> ans,List<Integer> list,int sum){
        int n=nums.length;
        if(i==n && sum<target) return;
           if(i==n ){ 
            if(sum==target) ans.add(new ArrayList<>(list));
            return;
         }

            if(sum<=target){
                list.add(nums[i]);
            combine(i,nums,target,ans,list,sum+nums[i]);
            list.remove(list.size()-1);
            }
            combine(i+1,nums,target,ans,list,sum);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(0,candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
}