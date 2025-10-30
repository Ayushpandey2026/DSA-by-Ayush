class Solution {
    private void combine(List<String> ans,String[] str,String digits,String s,int index){
        if(index==digits.length()){
            ans.add(s);
            return;
        }
        String letters = str[digits.charAt(index)-'0'];
        for(char c : letters.toCharArray()){
            combine(ans,str,digits,s+c,index+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] str = {"","","abc","def","ghi","jkl","mno",
        "pqrs","tuv","wxyz"};
        combine(ans,str,digits,"",0);
        return ans;

    }
}