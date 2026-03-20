class Pair{
    int node ; 
    int dis;
    Pair(int d , int n ){
        this.node = n ;
        this.dis = d;
    }
}

class Graph {
    
    List<List<Pair>> adj ;
    int n ;
    public Graph(int n, int[][] edges) {
        this.n = n ; 
        adj = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int dis = e[2];

            adj.get(u).add(new Pair(dis, v));
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        adj.get(u).add(new Pair(wt , v));
    }
    
    public int shortestPath(int node1, int node2) {
        int [] distance = new int[n];
        Arrays.fill(distance , Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        distance[node1] = 0 ; 
        pq.add(new Pair(0 , node1));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDis = curr.dis;

            if(currDis > distance[currNode]) continue;
            if(currNode == node2) return distance[currNode];

            for(Pair ite : adj.get(currNode)){
                int nextNode = ite.node;
                int nextDis = ite.dis;

                if(distance[nextNode] > nextDis + currDis){
                    distance[nextNode] = nextDis + currDis;
                    pq.offer(new Pair(distance[nextNode] , nextNode));
                }
            }
        }
        return -1 ; 
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */