class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] arr= new int[26];
            for(int j=i;j<n;j++){
            arr[s.charAt(j)-'a']++;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int ele : arr){
                if(ele>0){
                max=  Math.max(max,ele);
                min = Math.min(min,ele);
            }
        }
        ans +=max-min;
            }
        }
        return ans;
    }
}