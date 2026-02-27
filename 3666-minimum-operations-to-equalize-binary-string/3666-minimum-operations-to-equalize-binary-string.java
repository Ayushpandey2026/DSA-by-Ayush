class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z0 = 0;
        for (char c : s.toCharArray()) if (c == '0') z0++;

        if (z0 == 0) return 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        dist[z0] = 0;
        q.add(z0);
        TreeSet<Integer> evens = new TreeSet<>();
        TreeSet<Integer> odds = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            if (i == z0) continue;
            if (i % 2 == 0) evens.add(i);
            else odds.add(i);
        }

        while (!q.isEmpty()) {
            int z = q.poll();
            int min_i = Math.max(0, k - (n - z));
            int max_i = Math.min(z, k);

          
            int nextZ_max = z + k - 2 * min_i;
            int nextZ_min = z + k - 2 * max_i;

            TreeSet<Integer> targetSet = (nextZ_min % 2 == 0) ? evens : odds;
            
            Integer next = targetSet.ceiling(nextZ_min);
            while (next != null && next <= nextZ_max) {
                dist[next] = dist[z] + 1;
                if (next == 0) return dist[next];
                q.add(next);
                targetSet.remove(next); 
                next = targetSet.ceiling(nextZ_min);
            }
        }

        return dist[0];
    }
}