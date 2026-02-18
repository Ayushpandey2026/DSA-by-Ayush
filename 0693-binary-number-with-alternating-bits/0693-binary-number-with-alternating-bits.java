class Solution {
    public boolean hasAlternatingBits(int n) {
        String binari = Integer.toBinaryString(n);
        for(int i=0;i<binari.length()-1;i++){
            if(binari.charAt(i)==binari.charAt(i+1)) return false;
        }
        return true;
    }
}