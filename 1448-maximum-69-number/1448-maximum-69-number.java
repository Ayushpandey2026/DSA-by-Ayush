class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        char[] sb = s.toCharArray();
        int n = sb.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(sb[i]=='6' && cnt==0){
                 sb[i] = '9';
                 cnt++;
                 break;
            } 
        }
        s = new String(sb);
        String cleaned = s.replaceAll("\\s+", ""); 
        int val = Integer.parseInt(cleaned);
        return val;
    }
}