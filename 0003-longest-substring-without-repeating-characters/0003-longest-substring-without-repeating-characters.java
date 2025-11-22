class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int j=0;
        int max = 0;
        HashSet<Character> set= new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))){
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
            set.add(s.charAt(i));
                int len = set.size();
                max=Math.max(len,max);
        }
        return max;
    }
}