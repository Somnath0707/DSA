class Pair{
    int distance ;
    int node ; 

    Pair(int d , int n ){
        this.distance = d ; 
        this.node = n; 
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // create a new list 
        List<List<Pair>> adj = new ArrayList<>();

        // make a outine of this
        for(int i = 0; i<= n ; i++){
            adj.add(new ArrayList<>());
        }


        // add the connection along with the weight 
        for(int i = 0; i < times.length ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adj.get(u).add(new Pair(wt , v));

        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y ) -> x.distance - y.distance);

        int distance[] = new int[n+1];
        Arrays.fill(distance , Integer.MAX_VALUE);
        if(k > times.length) return -1; 
        distance[k] = 0 ; 

        pq.add(new Pair(0 , k));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int currDis = curr.distance; 
            int currNode = curr.node;

            for(Pair it : adj.get(currNode)){
                int nextDis = it.distance;
                int nextNode = it.node;

                if(distance[nextNode] > currDis + nextDis){
                    distance[nextNode] = currDis + nextDis;

                    pq.add(new Pair(distance[nextNode] , nextNode));
                }
            }
        }
        int ans = -1 ; 
        for(int i = 1 ; i < n+1 ; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1 ; 
            ans = Math.max(ans , distance[i]);
        }
        return ans;
    }
}