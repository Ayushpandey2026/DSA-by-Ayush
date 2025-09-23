class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int num = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=num){
                st.pop();
            }
            nse[i] = (st.isEmpty()) ? n: st.peek();
            st.push(i);
        }

    st.clear();

     for(int i=0;i<n;i++){
            int num = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=num){
                st.pop();
            }
            pse[i] = (st.isEmpty()) ? -1: st.peek();
            st.push(i);
        }
         int max=0;
         for(int i=0;i<n;i++){
           int width = nse[i]-pse[i]-1;
           int area = width*heights[i];
           max = Math.max(area,max);
        }
    return max;
    }

}