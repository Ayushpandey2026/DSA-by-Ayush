class Solution {
    public int expandFromCenter(String s , int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
       if (s == null || s.length() < 1) return "";
        int start=0, end=0;
        for(int i=0;i<n;i++){
            int len1 = expandFromCenter(s,i,i);
            int len2 = expandFromCenter(s,i,i+1);
            int len = Math.max(len1,len2);

            if(end-start<len){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
}