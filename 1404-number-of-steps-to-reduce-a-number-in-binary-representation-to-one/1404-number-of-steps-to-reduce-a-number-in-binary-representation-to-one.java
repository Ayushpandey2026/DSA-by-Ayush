class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0' + carry;
            
            if (digit == 1) {
                
                steps += 2;
                carry = 1;
            } else if (digit == 0) {
                steps += 1;
                carry = 0;
            } else if (digit == 2) {
                steps += 1;
                carry = 1;
            }
        } 
        return steps + carry;
    }
}