class Solution {
    private void combine(int i,List<List<Integer>> ans,List<Integer> list, int[] arr, int target){
        int n =arr.length;
        if(i==n && target<0){
            return;
        }
        if(i==n){
        if(target==0){
            ans.add(new ArrayList<>(list));
        }
          return;
        }
        if(arr[i]<=target){
        list.add(arr[i]);
        combine(i,ans,list,arr,target-arr[i]);
        list.remove(list.size()-1);
        }
        combine(i+1,ans,list,arr,target);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(0,ans,new ArrayList<>(),arr,target);
        return ans;
    }
}