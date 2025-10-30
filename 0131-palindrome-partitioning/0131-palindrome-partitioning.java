class Solution {
    private boolean checkpalin(String s, int st, int end){
        while(st<end){
            if(s.charAt(st++)!=s.charAt(end--)) return false;
        }
         return true;
    }
    private void palin(List<List<String>> ans, List<String> list, String s,int i){
        if(i==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int a=i;a<s.length();a++){
            if(checkpalin(s,i,a)){
            list.add(s.substring(i,a+1));
            palin(ans,list,s,a+1);
            list.remove(list.size()-1);
        }
        }
      
        

    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palin(ans,new ArrayList<>(),s,0);
        return ans;
    }
}