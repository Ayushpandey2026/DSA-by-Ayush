class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = Integer.bitCount(num2);
        int currentBits = Integer.bitCount(num1);
        int x = num1;

        if(currentBits > targetBits){
            int bitsToRemove = currentBits - targetBits;
            for (int i = 0; i < 32 && bitsToRemove > 0; i++){
                if(((x >> i) & 1) == 1){
                    x ^= (1 << i); 
                    bitsToRemove--;
                }
            }
        }
         else if (currentBits < targetBits){
            int bitsToAdd = targetBits - currentBits;
            for(int i = 0; i < 32 && bitsToAdd > 0; i++) {
                if (((x >> i) & 1) == 0) {
                    x |= (1 << i); 
                    bitsToAdd--;
                }
            }
        }
        return x;
    }
}