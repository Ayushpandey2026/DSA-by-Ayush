class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int val = (shift[2] == 1) ? 1 : -1;

            diff[start] += val;
            diff[end + 1] -= val;
        }

        char[] chars = s.toCharArray();
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += diff[i];
            int netShift = (currentShift % 26 + 26) % 26;
            
            int originalCharPos = chars[i] - 'a';
            int newCharPos = (originalCharPos + netShift) % 26;
            
            chars[i] = (char) ('a' + newCharPos);
        }
        return new String(chars);
    }
}