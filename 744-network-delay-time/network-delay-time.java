class Pair{
    int distance ; 
    int node ; 
    
    Pair(int d , int n ){
        this.distance = d ; 
        this.node = n ;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Make a adj list 
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<= n ; i ++){
            adj.add(new ArrayList<>());
        }
        // put the elemnt in the adj list 

        for(int i = 0 ; i< times.length ; i ++){
            int u = times[i][0]; // this is the curr node 
            int v = times[i][1];// the connection to the other node i.e which node is conntectd
            int wt = times[i][2]; // distance from curr to next node

            adj.get(u).add(new Pair(wt , v));// one direction only so 
        }

        int distance[] = new int[n+1]; // 1 indexed array

        Arrays.fill(distance , Integer.MAX_VALUE);

        distance[k] = 0 ; 

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);

        pq.add(new Pair(0 , k));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currDis = curr.distance ; 
            int currNode = curr.node;

            for(Pair it : adj.get(currNode)){
                int nextDis = it.distance ; 
                int nextNode = it.node;

                if(distance[nextNode] > currDis + nextDis){
                    distance[nextNode] = currDis + nextDis;

                    pq.add(new Pair(distance[nextNode] , nextNode));
                }
            }
        }
        int ans = 0 ; 
        for(int i = 1; i < distance.length; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1; 
            }
            ans = Math.max(ans , distance[i]);
        }
        return ans ; 
    }
}