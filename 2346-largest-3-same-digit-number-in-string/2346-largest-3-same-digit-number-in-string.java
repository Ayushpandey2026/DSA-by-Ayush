class Solution {
    public String largestGoodInteger(String num) {
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
        arr[i] = num.charAt(i) - '0'; 
        }
        int number = 0;
        int max =-1;
        for(int i=0;i<num.length()-2;i++){
            if(arr[i]==arr[i+1] && arr[i+1]==arr[i+2]){
                number = arr[i]*100 + arr[i]*11;
                max = Math.max(max,number);
            }
        }
        String st = String.valueOf(max);
        if(max>0) return st;
        if(max==0) return "000";
        return "";
    }
}