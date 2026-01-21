class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                found = true;
                for (int z = 0; z <= indices.size() - 3; z++) {
                    int i = indices.get(z);
                    int k = indices.get(z + 2);
                    int currentDistance = 2 * (k - i);
                    minDistance = Math.min(minDistance, currentDistance);
                }
            }
        }

        return found ? minDistance : -1;
    }
}