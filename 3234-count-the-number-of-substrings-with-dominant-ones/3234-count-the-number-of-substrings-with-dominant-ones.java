class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] prefixOnes = new int[n + 1];
        List<Integer> zeroIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (s.charAt(i) == '1' ? 1 : 0);
            if (s.charAt(i) == '0') {
                zeroIndices.add(i);
            }
        }

        int count = 0;
        int numZeros = zeroIndices.size();

        for (int i = 0; i < n; i++) {
            int zeroPtr = Collections.binarySearch(zeroIndices, i);
            if (zeroPtr < 0) zeroPtr = -(zeroPtr + 1);

            for (int z = zeroPtr; z <= numZeros; z++) {
                int zCount = z - zeroPtr;
                int zCountSq = zCount * zCount;

                if (zCountSq > n) break;

                int leftBound = (z == zeroPtr) ? i : zeroIndices.get(z - 1);
                int rightBound = (z == numZeros) ? n - 1 : zeroIndices.get(z) - 1;

                int currentOnesAtLeft = prefixOnes[leftBound + 1] - prefixOnes[i];
                
                int onesNeeded = Math.max(zCountSq - currentOnesAtLeft, 0);
                int startIdx = leftBound + onesNeeded;

                if (startIdx <= rightBound) {
                    count += (rightBound - startIdx + 1);
                }
            }
        }

        return count;
    }
}