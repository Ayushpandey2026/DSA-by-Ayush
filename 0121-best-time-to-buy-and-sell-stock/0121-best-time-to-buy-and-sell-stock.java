class Solution {
    public int maxProfit(int[] prices) {
       int  i=0; int max=0;
       int j=i+1; int n=prices.length;
       while(j<n){
        if(prices[i]>prices[j]) i++;
        else {
            max=Math.max(max,prices[j]-prices[i]);
            j++;
        }
       }
       return max;
    }
}