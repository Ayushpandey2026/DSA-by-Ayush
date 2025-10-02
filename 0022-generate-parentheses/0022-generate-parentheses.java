class Solution {
    List<String> list = new ArrayList<>();
    private List<String> pp(int op, int cl, int n , String s){
        if(s.length()==2*n){ 
            list.add(s);
        }
        if(op<n) pp(op+1,cl,n,s+'(');
        if(cl<op) pp(op,cl+1,n,s+')');
        return list;
    }
    public List<String> generateParenthesis(int n) {
       List<String> list= pp(0,0,n,"");
        return list;
    }
}