class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-1,j=n-2;
        while(j>=0 && nums[j]>=nums[j+1]){
            j--;
        }

        if(j>=0){
        while(i>=j){
            if(nums[i]>nums[j]) break;
            i--;
        }
             int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
        }
       

        int left = j + 1;
       int right = n - 1;

        while (left < right) {
       int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
       }
    }
}