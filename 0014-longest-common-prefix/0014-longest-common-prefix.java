class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n=strs.length;
        String a  = strs[n-1];
        String b = strs[0];

        if(a.equals(b)) return a;
        int i=0;
        int j =0;
        while(i<a.length() &&  j<b.length()){
        if( a.charAt(i)!=b.charAt(j)) 
        return a.substring(0,i);
            i++;
            j++;
        }
        return a.substring(0,i);
       
    }
}