class Solution {
    public boolean rotateString(String s, String goal) {
         int n=s.length();
     if(s.equals(goal)) return true;
      for(int i=1;i<n;i++){
         String st="";
         String str="";
            st = s.substring(0,i);
            str =s.substring(i);
            String result = str+st;
            if(result.equals(goal)) return true;
         }
         return false;
    }
}