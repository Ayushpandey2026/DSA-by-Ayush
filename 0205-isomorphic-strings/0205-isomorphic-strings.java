class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] chars = new int[256];
        int[] chart= new int[256];
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i);
            int y= t.charAt(i);

            if(chars[x] != chart[y]) return false;
                 chars[x] = i + 1;
                  chart[y] = i + 1;
    }
            return true;
        }
      
  }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            