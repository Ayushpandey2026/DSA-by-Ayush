class Solution {
    public String countAndSay(int n) {
        int i=0,j=0;
        if(n==1) return "1";
        String s = countAndSay(n-1);

        String ans = "";
        while(j< s.length()){
                if(s.charAt(i)==s.charAt(j)){
                    j++;
                }
                else{
                    int len = j-i;
                    ans +=len;
                    ans +=s.charAt(i);
                    i=j;
                }
        }
        int len = j-i;
       ans +=len;
       ans +=s.charAt(i);
       return ans;
    }
}