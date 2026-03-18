class Pair{
    int node ;
    int dis;
    
    Pair(int n , int d){
        this.node = n ; 
        this.dis = d;
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i< edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v , wt));
            adj.get(v).add(new Pair(u , wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        int city = 0 ; 
        int cities = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int distance[] = new int[n];
            Arrays.fill(distance , Integer.MAX_VALUE);
            distance[i] = 0; 
            pq.add(new Pair(i , 0));

            while(!pq.isEmpty()){
                Pair curr = pq.poll();
                int currNode = curr.node;
                int currDis = curr.dis;

                for(Pair ite : adj.get(currNode)){
                    int nextNode = ite.node;
                    int nextDis = ite.dis;

                    int newDis = currDis + nextDis;

                    if(newDis <= distanceThreshold && newDis < distance[nextNode]){
                        distance[nextNode] = newDis;
                        pq.add(new Pair(nextNode , newDis));
                    }
                }
            }
            int reachableCities = 0 ; 
            for(int j = 0 ; j < n ; j++ ){
                if(i != j && distance[j] != Integer.MAX_VALUE){
                    reachableCities ++;
                }
            }
             if(reachableCities <= cities){
                city = i;
                cities = reachableCities;
            }
        }
    return city;
    }
}