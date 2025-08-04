class Solution {
    public void dfs(int i,int[][] adj, boolean[] vis ){
        int n = adj.length;
        vis[i] =true;
        for(int j=0;j<n;j++){
            if(vis[j]==false && adj[i][j] ==1){
                dfs(j,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n  = adj.length; int count=0;
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(vis[i]==false){
            dfs(i,adj,vis);
            count++;
        }
        }
        return count;
    }
}