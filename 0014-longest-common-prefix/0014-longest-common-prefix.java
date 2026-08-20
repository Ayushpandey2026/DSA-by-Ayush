class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        if(strs.length==1) return strs[0];
        String str=strs[0]+" ";
        String s=strs[strs.length-1]+" ";
        if(str.equals(s)==true) return s.trim();
        for(int i=0;i<Math.max(str.length()-1,s.length()-1);i++){
            if(str.charAt(i)!=s.charAt(i)){
                return str.substring(0,i);
            }
        }
        return "";
    }
}