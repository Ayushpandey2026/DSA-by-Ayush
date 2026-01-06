class Solution {
    public void bfs(int i,boolean[] vis,int[][] adj){
        vis[i]=true;
         int n=adj.length;
        Queue<Integer> q =new LinkedList<>();
        q.add(i);
        while(!q.isEmpty() ){
            int front = q.remove();
            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && vis[j]==false){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                count++;
            }
        }
        return count;
    }
}