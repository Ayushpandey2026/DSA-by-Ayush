class Solution {
    public int[] productExceptSelf(int[] nums) {
          int n = nums.length;
          int[] num = new int[n];
          num[0]=1;
          for(int i=1;i<n;i++){
            num[i] =num[i-1] *  nums[i-1] ;
          } 

          int[] numss = new int[n];

           numss[n-1] = 1;
           for(int i=n-2;i>=0;i--){
            numss[i] = numss[i+1] * nums[i+1];
          }  
          int[] res = new int[n];
          for(int i=0;i<num.length;i++){
            res[i] = num[i] * numss[i];
          }
          return res;
    }
}