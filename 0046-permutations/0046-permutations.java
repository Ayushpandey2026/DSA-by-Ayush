class Solution {
    private void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> list ){
        if(list.size()==nums.length) {
            ans.add(new ArrayList<>(list));
             return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums,ans,list);
            list.remove(list.size()-1);

        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,ans,new ArrayList<>());
        return ans;
    }
}