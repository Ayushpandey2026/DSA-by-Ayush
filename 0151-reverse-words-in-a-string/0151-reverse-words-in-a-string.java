class Solution {
    public String reverseWords(String s) {
        String str = "";
        String[] sarr = s.trim().split(" ");
        for(int i=sarr.length-1;i>=0;i--){
            str +=sarr[i]+" ";
        }
        return str.trim().replaceAll("\\s+"," ");
    }
}