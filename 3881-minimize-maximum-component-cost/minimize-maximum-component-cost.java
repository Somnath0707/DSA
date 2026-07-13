class Solution {
    public void f(boolean vis[] , int node , List<List<Integer>> list){
        vis[node] = true ;

        for(int e : list.get(node)){
            if(!vis[e]) 
            f(vis , e , list);
        }
    }
    public int check(int mid , int edges[][] , int n ){
        List<List<Integer>> list = new ArrayList<>(); 

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int u = e[0]; 
            int v = e[1]; 
            int weight = e[2]; 

            if( weight <= mid){
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }


        boolean vis[] = new boolean[n]; 
        int component = 0; 
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                f(vis , i , list);
                component++; 
            }
        }

        return component; 
    }
    public int minCost(int n, int[][] edges, int k) {
        // Arrays.sort(edges , (a,b)-> a[2] - b[2]);
        if(n == k) return 0 ; 
        int left = 1 ; 
        int m = edges.length; 
        int right = 10000000;
        int ans = 0 ; 
        while(left <= right){
            int mid = left + (right - left ) / 2 ;

            if(check(mid , edges ,  n ) <= k){
                ans = mid ; 
                right = mid -1 ; 
            }
            else {
                left = mid + 1 ; 
            }
        } 

        return ans; 

        
    }
}

// can we do like take the edge with heightest weight and try remove it and check the number of componets if components > k stop 
// if this works try removing the next largest edge and keep checking the the number of components
// but after getting the largest edge we make it as a seperate component and then remove that edge


// so we make a int which has the count of the connected componet if the conneted componed increase beyond the k then ew just return the max that 