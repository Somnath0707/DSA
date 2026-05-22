class Edge{
    int to; 
    int cost; 
    int tax; 
    Edge(int to , int cost , int tax){
        this.to = to ;
        this.cost = cost ; 
        this.tax = tax;
    }
}

class Solution {

    public long[] dijkstra(int src , List<Edge>[] graph , boolean loaded){
        int n = graph.length;

        long dis[] = new long[n];
        Arrays.fill(dis , Integer.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0 , src});
        dis[src] = 0 ; 

        while(!pq.isEmpty()){
            long curr[] = pq.poll();
            long distance = curr[0];
            int u = (int)curr[1];

            if(distance > dis[u]) continue;

            for(Edge e : graph[u]){
                int to = e.to;
                long cost = e.cost;
                long tax = e.tax;

                long weight ; 
                if(loaded){
                    weight = cost * tax;
                }else{
                    weight = cost ;
                }
                long newDis = distance + weight;
                if(dis[to] > newDis){
                    dis[to] = newDis;
                    pq.offer(new long[]{newDis , to});
                }
            }
        }
        return dis;
    }
    
    public int[] minCost(int n, int[] prices, int[][] roads) {
        List<Edge>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int r[] : roads){
            int u = r[0];
            int v = r[1];
            int cost = r[2];
            int tax = r[3];

            graph[u].add(new Edge(v , cost , tax));
            graph[v].add(new Edge(u , cost , tax));
        }


        long empty[][] = new long[n][n]; 
        long loaded[][] = new long[n][n];


        for(int i =0 ; i <  n ; i++){
            empty[i] = dijkstra(i , graph , false);
            loaded[i] = dijkstra(i , graph , true);
        }


        int ans[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            ans[i] = prices[i];
            for(int j = 0 ; j < n ; j++){
                if(empty[i][j] == Integer.MAX_VALUE || loaded[i][j] == Integer.MAX_VALUE){
                    continue;
                }

                long total = empty[i][j] + loaded[j][i] + prices[j];

                long temp = Math.min(ans[i] , total);
                ans[i] = (int)temp;
            }
        }

        return ans;

    }
}