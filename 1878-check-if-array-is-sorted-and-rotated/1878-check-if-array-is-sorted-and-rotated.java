class Solution {
    public boolean check(int[] nums) {
        int[] num = new int[nums.length];
        int x=0;
        while( x<nums.length-1 &&  nums[x+1] >= nums[x]){
            x++;
        }

        for(int i= 0;i<nums.length;i++){
            num[i] = nums[(i+x+1)%nums.length];
        }
          for(int i= 0;i<num.length-1;i++){
            if(num[i+1] < num[i]) return false;
        }
        return true;
    }
}