class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor = xor ^ num;
        }

        int rightbit = xor & (-xor);
        int a =0, b=0;
        for(int num : nums){
            if((rightbit & num)==0) a ^=num;
            else b ^=num; 
        }    
        int[] arr  = new int[2];
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
}