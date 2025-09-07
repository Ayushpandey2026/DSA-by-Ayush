class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
    if (A.length > B.length) {
        return findMedianSortedArrays(B, A);
    }

    int m = A.length, n = B.length;
    int low = 0, high = m, halfLen = (m + n + 1) / 2;
    while (low <= high) {
        int i = (low + high) / 2;
        int j = halfLen - i;

        int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
        int Aright = (i == m) ? Integer.MAX_VALUE : A[i];
        int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
        int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

        if (Aleft <= Bright && Bleft <= Aright) {
            if ((m + n) % 2 == 1) {
                return Math.max(Aleft, Bleft);
            } else {
                return ( (double)Math.max(Aleft, Bleft) + Math.min(Aright, Bright) ) / 2;
            }
        } else if (Aleft > Bright) {
            high = i - 1;
        } else {
            low = i + 1;
        }
    }
    throw new IllegalArgumentException("No median found");
}

}