class Solution {
    public int cost(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        int min =Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<=j;k++){
            int len =  arr[j+1] - arr[i-1] ;
            int tcost = cost(i,k-1,arr,dp) + cost(k+1,j,arr,dp) + len;
            min = Math.min(min,tcost);
        }
        return dp[i][j]= min;
    }
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        int i;
        int m= arr.length;
        int[][] dp = new int[m-1][m-1];
        for(int a=0;a<m-1;a++){
            Arrays.fill(dp[a],-1);
        }

        for( i=0;i<cuts.length;i++)
        {
            arr[i] =cuts[i];
        }
        arr[i++]=0;
        arr[i]=n;
        Arrays.sort(arr);
        return cost(1,arr.length-2,arr,dp);
    }
}