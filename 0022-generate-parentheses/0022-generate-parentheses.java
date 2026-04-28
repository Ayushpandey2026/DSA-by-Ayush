class Solution {
    List<String> list = new ArrayList<>();
    private List<String> generate(String str, int op, int cl,int n){
        if(str.length()==2*n) {
            list.add(str);
        }
       if(op<n) generate(str+ "(",op+1,cl,n);
        if(cl<op) generate(str+")",op,cl+1,n);
        return list;

    }
    public List<String> generateParenthesis(int n) {
        List<String> list =generate("",0,0,n);
         return list;
    }
}