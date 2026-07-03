class Solution {
    public boolean check(long mid ,  int[][] edges, boolean[] online, long k , List<List<int[]>> list){
        
        int n = online.length ;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            return Long.compare(a[1] , b[1]); 
        });

        pq.offer(new long[]{0 , 0 });
        
        long dist[] = new long[n];

        Arrays.fill(dist , Long.MAX_VALUE) ;

        dist[0] = 0 ; 


        while(!pq.isEmpty()){
            long curr[] = pq.poll(); 

            int node = (int)curr[0]; 
            long cost = curr[1]; 
            if (cost > dist[node]) continue;
            if(node == n-1) return true; 

            for(int num[] : list.get(node)){
                int nextNode =(int) num[0] ; 
                long nextCost = num[1]; 

                long newCost = nextCost + cost; 
                if(newCost > k || nextCost < mid || !online[nextNode]) continue; 

                if(dist[nextNode] > newCost){
                dist[nextNode] = newCost; 
                pq.offer(new long[]{nextNode , newCost});
                }
            }
        }

        return false ;

    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;  
        List<List<int[]>> list = new ArrayList<>(); 

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int u = e[0]; 
            int v = e[1]; 
            int cost = e[2]; 

            list.get(u).add(new int[]{v , cost});
        }
        // dijkstra 
        // but here instead of just distance we also have to store the minValue 
        // at end we it should have checked all the routes and and should have the answer if the  sum > k we dont go that way 
        // if sum <= k then we go till end and at end we update the minvalue 

        // but in distance array why do we even know the distance just to check with k so we dont need actually a real cost in the dist array we only need it should keep the value which is lowest for each and highest at the end
       long min = Integer.MAX_VALUE; 
       long ans = -1 ; 

       long max = Integer.MIN_VALUE; 
       for (int i = 0; i < edges.length ; i++){
        min = Math.min(edges[i][2] , min);
        max = Math.max(edges[i][2] , max);
       }

       long left = min; 
       long right = max; 

       while(left <= right ){
        long mid = left + (right - left ) / 2; 

        if(check(mid , edges , online , k , list)){
            ans = mid; 
            left = mid + 1; 
        }
        else {
            right = mid - 1; 
        }
       }


       return(int) ans; 
    }
}