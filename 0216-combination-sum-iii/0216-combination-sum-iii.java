class Solution {
public void compute(List<List<Integer>> ans,List<Integer> list,int k,int target,int start){
    if(list.size()==k && target==0){
        ans.add(new ArrayList<>(list));
        return;
    }
    for(int i=start;i<=9;i++){
         if(target<i) break;
         list.add(i);
         compute(ans,list,k,target-i,i+1);
         list.remove(list.size()-1);
    }
}
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(ans,new ArrayList<>(),k,n,1);
        return ans;
    }
}