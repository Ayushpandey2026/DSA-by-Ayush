class Solution {
    public int maxGoodNumber(int[] nums) {
        int n = nums.length;
        String[] binary = new String[n];
        
        for (int i = 0; i < n; i++) {
            binary[i] = Integer.toBinaryString(nums[i]);
        }
        
        int maxVal = 0;
        
        int[][] permutations = {
            {0, 1, 2}, {0, 2, 1}, 
            {1, 0, 2}, {1, 2, 0}, 
            {2, 0, 1}, {2, 1, 0}
        };
        
        for (int[] p : permutations) {
            StringBuilder sb = new StringBuilder();
            sb.append(binary[p[0]]);
            sb.append(binary[p[1]]);
            sb.append(binary[p[2]]);
            
            int currentVal = Integer.parseInt(sb.toString(), 2);
            maxVal = Math.max(maxVal, currentVal);
        }
        
        return maxVal;
    }
}