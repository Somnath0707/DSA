class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>(); 
        
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int u = e[0]; 
            int v = e[1]; 
            list.get(u).add(v);
            list.get(v).add(u);
        }


        boolean vis[] = new boolean[n] ; 

        int completeComponent = 0 ; 

        for(int i = 0; i < n ; i++){
            if(vis[i] != true){
                List<Integer> component = new ArrayList<>(); 

                Queue<Integer> q = new LinkedList<>(); 

                q.add(i);
                vis[i] = true; 

                while(!q.isEmpty()){
                    int curr= q.poll();

                    component.add(curr);

                    for(int num : list.get(curr)){
                        if(!vis[num]){
                            q.add(num);
                            vis[num] = true; 
                        }
                    }
                }


                boolean isComplete = true; 

                for(int node : component){
                    if(list.get(node).size() != component.size()-1 ){
                        isComplete = false; 
                        break ;
                    }
                }
                if(isComplete){
                    completeComponent++; 
                }
            }
        }

        return completeComponent;

    }
}