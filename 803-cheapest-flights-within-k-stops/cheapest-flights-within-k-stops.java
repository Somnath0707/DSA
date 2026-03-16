class pair{
    int first;
    int second;
    pair(int f , int s ){
        this.first = f ; 
        this.second = s ; 
    }
}

class triple{
    int stop ;
    int node ; 
    int cost;
    triple(int s , int n , int c){
        this.stop= s; 
        this.node = n ; 
        this.cost = c;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();

        int m = flights.length;
        for(int i =0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0 ; i < m ;i++ ){
            int u = flights[i][0];
            int v = flights[i][1];
            int cos = flights[i][2];

            adj.get(u).add(new pair(v , cos));
        }
        
        int distance[] = new int[n];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[src] = 0; 
        Queue<triple> q = new LinkedList<>();

        q.offer(new triple(0 , src , 0));

        while(!q.isEmpty()){
            triple curr = q.poll();

            int currStops = curr.stop;
            int currNode = curr.node;
            int currCost = curr.cost;

            if(currStops > k) continue;

            for(pair ite : adj.get(currNode)){
                
                int nextNode = ite.first;
                int nextCost = ite.second;

                if(currCost + nextCost < distance[nextNode] && currStops <= k ){
                    distance[nextNode] = currCost + nextCost;

                    q.add(new triple(currStops+1 , nextNode , distance[nextNode]));
                }    
            }
        }

        if(distance[dst] == Integer.MAX_VALUE) return -1 ; 
        return distance[dst];


    }
}