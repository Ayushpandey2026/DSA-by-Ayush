class Solution {
    public boolean check(int[] nums) {
        int cnt=0;
        int n=nums.length; int x=0;
        int[] num = new int[nums.length];
        while(x<n-1 && nums[x] <= nums[x+1]){
            x++;
        }  

        for(int i=0;i<nums.length;i++){
           num[i] =nums[(i+x+1) % nums.length];
        }
  
        for(int i=0;i<nums.length-1;i++){
          if(num[i+1]<num[i]) return false;
        } 
         return true;     
       
    }
}