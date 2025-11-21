class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int[] arr = new int[3];
        arr[0]=0;arr[1]=1;
        for(int i=1;i<=n-1;i++){
            arr[2] = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] =arr[2];
        }
        return arr[2];
    }
}