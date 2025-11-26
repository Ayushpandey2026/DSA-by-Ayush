class Solution {
    public int lcs(String s, String st, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==st.charAt(j)) return  dp[i][j]= 1 +  lcs(s,st,i-1,j-1,dp);
        else{
            return dp[i][j] =  Math.max(lcs(s,st,i-1,j,dp),lcs(s,st,i,j-1,dp));
        }

    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder st = new StringBuilder(s);
        int n=s.length();
        if(n==0) return 0;
        int[][] dp =new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return  lcs(s,st.reverse().toString(),n-1,n-1,dp);
    }
}