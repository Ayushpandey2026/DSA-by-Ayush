class Solution {
    public boolean isPalindrome(String s) {
        // s.replaceAll("\\s","").toLowerCase();
         String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = result.length();
        int i = 0, j = n-1;
        while( i < j){
            if(result.charAt(i) == result.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}