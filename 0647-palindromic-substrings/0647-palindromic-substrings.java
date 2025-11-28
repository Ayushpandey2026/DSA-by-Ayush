class Solution {
    public int countSubstrings(String s) {
        int n =s.length();
        int[][] dp =new int[n][n];
        int cnt=0;
        for(int i=0;i<n;i++){
            int j=0, k=i;
            while(k<n){
                if(j==k){
                    dp[j][k]=1;
                    cnt++;
                }
                else if(k==j+1){
                    if(s.charAt(j)==s.charAt(k)){
                    dp[j][k]=1;
                    cnt++;
                }
                }
                else{
                    if(s.charAt(j)==s.charAt(k)){
                        if(dp[j+1][k-1]==1){
                            dp[j][k]=1;
                            cnt++;
                        }
                    }
                }
                
            j++;k++;
            }
        }
        return cnt;
    }
}