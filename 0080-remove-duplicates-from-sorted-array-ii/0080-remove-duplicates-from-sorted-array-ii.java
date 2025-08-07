class Solution {
    public int removeDuplicates(int[] nums) {
              int n = nums.length; int cnt=0; int i=0,j=0; int mark=0;
              while(j<n){
                if(nums[i]==nums[j] && cnt <2){
                    nums[mark++] = nums[j];
                    cnt++; 
                    if(j<n) j++;
                }
               else if(nums[i]==nums[j] && cnt>=2){
                    if(j<n) j++;
                }
               else if(nums[i]!=nums[j]){
                    cnt=0; 
                    nums[mark++] = nums[j];
                    cnt++; i=j;
                    if(j<n) j++;
                }

              }
              return mark;
    }
}