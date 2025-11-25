class Solution {
    public int calc(String t1, String t2,int i,int j, int[][] dp){

        if(i<0 || j<0) return 0; 
        if(dp[i][j]!=-1) return dp[i][j];
        if(t1.charAt(i)==(t2.charAt(j)))  return  dp[i][j] = 1 + calc(t1,t2,i-1,j-1,dp);
        else{
           return  dp[i][j] =  Math.max(calc(t1,t2,i-1,j,dp),calc(t1,t2,i,j-1,dp));
        }
    }
    public int longestCommonSubsequence(String a, String b) {
        // calc(text1,text2,i,j);
           int m=a.length();
           int n=b.length();
           if(m==0 || n==0) return 0;
        int[][] dp =new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return  calc(a,b,m-1,n-1,dp);
    }
}