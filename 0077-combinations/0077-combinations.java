class Solution {
    private void backtrack(int start,int n, int k,  List<List<Integer>> ans, List<Integer> list){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n;i++){
             list.add(i);
            backtrack(i+1,n,k,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> ans = new ArrayList<>();
         backtrack(1,n,k,ans,new ArrayList<>());
         return ans;
    }
}