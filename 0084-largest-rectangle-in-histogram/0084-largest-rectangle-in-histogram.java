class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++){
            int minh =(i==n) ? 0 : arr[i];
            while(!st.isEmpty() && minh < arr[st.peek()]){
                int h = arr[st.pop()];
                int right =i;
                int left = st.isEmpty() ? -1 : st.peek();
                int width =right-left-1; 
                max= Math.max(max,h*width);
            }
            st.push(i);
        }
        return max;
    }
}