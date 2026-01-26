class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            // for(int j=i+1;j<n;j++){
                min =Math.min(min,Math.abs(nums[i-1]-nums[i]));
           // }
        }

        for(int i=1;i<n;i++){
         List<Integer> list=new ArrayList<>();
            // for(int j=i+1;j<n;j++){
                if(Math.abs(nums[i-1]-nums[i]) == min) {
                    list.add(nums[i-1]);
                    list.add(nums[i]);
                }

            //}
         if(list.size()>0)   ans.add(list);
        }

        return ans;
    }
}