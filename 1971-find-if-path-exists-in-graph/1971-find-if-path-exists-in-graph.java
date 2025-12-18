class Solution {
   private void bfs(int start,boolean[] vis,List<List<Integer>> adj){
        int n=adj.size();
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                vis[ele]=true;
                q.add(ele);
                }
            }
        }
   }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b =edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);

        }
        boolean[] vis= new boolean[n];
        vis[start]=true;
        bfs(start,vis,adj);
        return vis[end];
    }
}