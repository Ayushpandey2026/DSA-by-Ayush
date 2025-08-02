class Solution {
    public void  bfs(int start,List<List<Integer>> rooms, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(que.size()>0){
             int front = que.poll();
             for(int ele :rooms.get(front) ){
                if(visited[ele]==false){
                    visited[ele]=true;
                    que.add(ele);
                }
             }


        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        bfs(0,rooms,visited);
        for(boolean ele :visited){
            if(ele == false) return false;
        }
        return true;
        }

    }
