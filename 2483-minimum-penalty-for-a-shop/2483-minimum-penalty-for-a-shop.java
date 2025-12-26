class Solution {
    public int bestClosingTime(String customers) {
        int n= customers.length();
        int[] pren =new int[n+1];
        int[] sufy =new int[n+1];
        int[] ans =new int[n+1];
         pren[0]=0;
         for(int i=1; i<=n;i++){
            pren[i] = pren[i-1];
            if(customers.charAt(i-1)=='N') pren[i] +=1;
         }
          for(int i=n-1; i>=0;i--){
            sufy[i] = sufy[i+1];
            if(customers.charAt(i)=='Y') sufy[i] +=1;
         }
           int min= n+5;
          for(int i=0; i<=n;i++){
                ans[i] =pren[i] + sufy[i];
                min = Math.min(min,ans[i]);
         }
          for(int i=0; i<=n;i++){
           if(ans[i] == min) return i;
         }
            return 22;
    }
}
