class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m=g.length;
        int n=s.length; int cnt=0; int index=0;
        for(int i=0;i<m;i++){
            for(int j=index;j<n;j++){
                if(s[j] >= g[i]) {
                    cnt++;
                    index = j+1;
                    break;
                }
            }
            if(index==n) break;
        }
        return cnt;
    }
}