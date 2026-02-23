class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalRequired = 1 << k; 
        
        Set<String> foundCodes = new HashSet<>();
        
        for (int i = 0; i <= s.length() - k; i++) {
            foundCodes.add(s.substring(i, i + k));
            
            if (foundCodes.size() == totalRequired) {
                return true;
            }
        }
        
        return false;
    }
}