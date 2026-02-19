class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevGroupLen = 0;
        int currGroupLen = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLen++;
            } else {
                count += Math.min(prevGroupLen, currGroupLen);
                
                prevGroupLen = currGroupLen;
                currGroupLen = 1;
            }
        }
        return count + Math.min(prevGroupLen, currGroupLen);
    }
}