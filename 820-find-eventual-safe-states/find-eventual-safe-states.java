class Solution {
    public Boolean dfs(int i , int[][] graph , int vis[] , int pathVis [] , int check[]){
        vis[i] = 1 ; 
        pathVis[i] = 1 ; 
        check[i] = 0;

        for(int it : graph[i]){
            if(vis[it] == 0 ){
                if(dfs(it , graph , vis , pathVis , check )) return true; 
            }

            else if(pathVis[it] == 1) {
                return true; 
            }
        }
        check[i] = 1 ; 
        pathVis[i] = 0 ; 
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int V = graph.length ;
        int [] vis = new int[V];
        int [] pathVis = new int[V];
        int [] check = new int[V];

        for(int i = 0; i < V ; i++){
            if(vis[i] == 0 ) {
                dfs(i , graph , vis , pathVis , check );
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            if(check[i] == 1 ) list.add(i);
        }
        return list ;
    }
}