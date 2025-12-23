class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int a=0; int n = nums.length;
        k=k%n;
        for(int i=n-k;i<n;i++){
            arr[a++] = nums[i];
        }
        for(int i=0;i<n-k;i++){
            arr[a++] = nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i] = arr[i];
        }
    }
}