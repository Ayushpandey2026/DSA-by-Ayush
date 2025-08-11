public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;          // Number of jumps made
        int currentEnd = 0;     // End of the range for the current jump
        int farthest = 0;       // Farthest index reachable in the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;             // We must jump here
                currentEnd = farthest; // Set new range end

                // Optional: early exit if we can already reach the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
