class Solution {
    private int minUnfairness = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        backtrack(cookies, 0, children, k);
        return minUnfairness;
    }

    private void backtrack(int[] cookies, int index, int[] children, int k) {
        if (index == cookies.length) {
            int currentMax = 0;
            for (int count : children) {
                currentMax = Math.max(currentMax, count);
            }
            minUnfairness = Math.min(minUnfairness, currentMax);
            return;
        }

        
        for (int i = 0; i < k; i++) {
            if (children[i] + cookies[index] >= minUnfairness) continue;

            children[i] += cookies[index];
            backtrack(cookies, index + 1, children, k);
            children[i] -= cookies[index]; 
            if (children[i] == 0) break;
        }
    }
}