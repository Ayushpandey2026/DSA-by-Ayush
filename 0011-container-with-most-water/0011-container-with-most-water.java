class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length; 
        int max=-1;
       int i=0,j=n-1;
       while(i<=j){
        int len=j-i;
        int min =Math.min(arr[i],arr[j]);
        int sum  =len * min;
        max = Math.max(max,sum);
       
       if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
       }
        
     
      return max;
    }
}