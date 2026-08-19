class Solution {
    int timer = 0 ; 
    public void dfs(int node , int parent , boolean[] vis , int[] tin , int low[] , List<List<Integer>> ans ,List<List<Integer>> list ){
        
        vis[node] = true; 

        tin[node] = low[node] = timer ;
        timer++; 
        for(int num : list.get(node)){
            if(num == parent) continue ; 
            if(!vis[num]){
                dfs(num , node , vis , tin , low , ans , list); 

                low[node] = Math.min(low[node] , low[num]);

                if(low[num] > tin[node]){
                    ans.add(Arrays.asList(num , node));
                }
            }
            else{
                low[node] = Math.min(low[node] , low[num]); 
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // If I remove a edge we definitly know that a and b are now not directly connected 
        // So we want to to know whether if this removed are we still able to reach that node 
        // how will we know that 😭

        // 0 1 2 3 4
        // 2 3 2 1 1

        //

        List<List<Integer>> list = new ArrayList<>(); 

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>()); 
        }

        for(List<Integer> temp : connections){
            int u = temp.get(0); 
            int v = temp.get(1); 
            list.get(u).add(v); 
            list.get(v).add(u); 
        }

        boolean vis[] = new boolean [n]; 

        int tin[] = new int[n]; 
        int low[] = new int[n]; 

        List<List<Integer>> ans = new ArrayList<>(); 
        dfs(0 , -1 , vis , tin , low , ans , list); 
        return ans; 

    }
}