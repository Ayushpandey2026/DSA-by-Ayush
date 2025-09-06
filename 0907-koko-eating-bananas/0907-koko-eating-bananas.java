class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1, high = 0; int ans=0;
          for (int pile : piles) {
            high = Math.max(high, pile); 
        }
        while(low<=high){
            int mid = low + (high - low) / 2;
            int sum=0;
            for (int pile : piles) {
            sum += Math.ceil((double)pile/mid);

        }
        if(sum<=h){
            ans=mid;
            high=mid-1;
        }
        else low=mid+1;
        }
        return ans;
    }
}