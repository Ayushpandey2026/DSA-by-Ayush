class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int common = gcd(dx, dy);
                dx /= common;
                dy /= common;

                String slope = dy + "/" + dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            maxPoints = Math.max(maxPoints, localMax + 1);
        }
        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}