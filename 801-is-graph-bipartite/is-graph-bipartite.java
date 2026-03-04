class Solution {
    public boolean bfs(int i , int [][] graph , int [] color){
        Queue<Integer> q = new LinkedList<>();

        color[i] = 0; 
        q.add(i ); 

        while(!q.isEmpty()){
            int node = q.poll();

            for(int adjNode : graph[node]){
                if(color[adjNode] == -1){
                    color[adjNode] = color[node] == 1 ? 0 : 1;
                    q.add(adjNode);
                }
                else if(color[adjNode] == color[node]) return false; 
            }
        }
        return true; 
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; 

        int color[] = new int [n];

        Arrays.fill( color , -1 ) ; 

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1 ) {
                if(!bfs(i , graph , color )) return false;
            }
        }
        return true; 
    }
}