class Solution {
    public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
        int MOD = 1_000_000_007;

        long res = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                count += left[st.pop()];
            }
            left[i] = count;
            st.push(i);
        }

        st.clear();
        for(int i=n-1;i>=0;i--){
            int count=1;
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                count += right[st.pop()];
            }
            right[i] =count;
            st.push(i);
        }
        for(int i=0;i<n;i++){
            long val = (long)left[i]*right[i]*arr[i];
            res = (res+val)%MOD;
        }
        return (int)res;
    }
}