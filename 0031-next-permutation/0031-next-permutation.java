class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;  int j=0,i=n-2; int cnt=0;
        for(i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                cnt++;
                for(j=n-1;j>i;j--){
                    if(nums[i]<nums[j]){
                       break;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                int a = i+1, b=n-1;
                while(a<b){
                    int t = nums[a];
                    nums[a] = nums[b];
                    nums[b] = t;
                    a++;
                    b--;
                }
                return;
            }
        } 
        int a = 0, b=n-1;
        if(cnt==0) {
                while(b<n &&  a<=b){
                    int t = nums[a];
                    nums[a] = nums[b];
                    nums[b] = t;
                    a++;
                    b--;
                }
        }
    }
}