class Solution {

    private int largestrectanglearea(int[] heights){
        int n = heights.length; int max=0;
        Stack<Integer> st = new Stack<>(); 

        for(int i=0;i<=n;i++){
            int h = (i==n ? 0 : heights[i]); 
            while(!st.isEmpty() && heights[st.peek()]>h){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                max = Math.max(max,height*width);

            }
            st.push(i);
            
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
       int  m=matrix.length; int maxarea=0;
       int n =matrix[0].length; int[] height = new int[n]; 
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]=='1'){
                height[j]+=1;
            }
            else{
                height[j]=0;
            }
        }
        maxarea = Math.max(maxarea,largestrectanglearea(height));
       }
        return maxarea;
    }
}