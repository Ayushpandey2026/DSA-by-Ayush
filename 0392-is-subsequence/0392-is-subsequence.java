class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0,cnt=0;
        int  n =s.length();
        int  m=t.length(); int check =-1;
        while(i<n){
            char c= s.charAt(i);
            for(int k=0;k<m;k++){
                 if(c == t.charAt(k) && check<k){
                    check =k;
                    cnt++;
                    break;
                 }
                 
            }
            i++;
        }
      return  ( cnt == n) ? true : false;
    }
}