class Solution {
    public static String printLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs.append(s1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public String shortestCommonSupersequence(String a, String b) {
        String lcs = printLCS(a, b);

        StringBuilder scs = new StringBuilder();
        int i = 0, j = 0, k = 0;

        while (k < lcs.length()) {
            while (i < a.length() && a.charAt(i) != lcs.charAt(k)) {
                scs.append(a.charAt(i));
                i++;
            }

            while (j < b.length() && b.charAt(j) != lcs.charAt(k)) {
                scs.append(b.charAt(j));
                j++;
            }

            scs.append(lcs.charAt(k));
            i++;
            j++;
            k++;
        }

        while (i < a.length()) scs.append(a.charAt(i++));
        while (j < b.length()) scs.append(b.charAt(j++));

        return scs.toString();
    }
}
