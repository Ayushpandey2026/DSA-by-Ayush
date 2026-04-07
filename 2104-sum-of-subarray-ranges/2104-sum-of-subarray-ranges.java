class Solution {
    private long minsub(int[] nums,int n){
        long res =0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int  i=0;i<n;i++){
            int cnt=1;
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                cnt += left[st.pop()];
            }
            left[i] = cnt;
            st.push(i);
        }
        st.clear();

        for(int  i=n-1;i>=0;i--){
            int cnt=1;
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                cnt += right[st.pop()];
            }
            right[i] = cnt;
            st.push(i);
        }
        for(int  i =0;i<n;i++){
            res += (long) left[i] * right[i] * nums[i];
        }
        return res;
    }

    private long maxsub(int[] nums,int n){
        long res =0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int  i=0;i<n;i++){
            int cnt=1;
            while(!st.isEmpty() && nums[st.peek()]< nums[i]){
                cnt += left[st.pop()];
            }
            left[i] = cnt;
            st.push(i);
        }
        st.clear();

        for(int  i=n-1;i>=0;i--){
            int cnt=1;
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                cnt += right[st.pop()];
            }
            right[i] = cnt;
            st.push(i);
        }
        for(int  i =0;i<n;i++){
            res += (long) left[i] * right[i] * nums[i];
        }
        return res;
    }

    public long subArrayRanges(int[] nums) {
        int n =nums.length;
        return maxsub(nums,n) - minsub(nums,n);
    }
}