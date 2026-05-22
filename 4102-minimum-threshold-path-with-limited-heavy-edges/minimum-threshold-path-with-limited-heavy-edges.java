class Edges{
    int u ; 
    int weight; 
    Edges(int u , int weight){
        this.u = u ; 
        this.weight = weight ;
    }
}

class Solution {
    int n ; 
    public boolean dijkstra(int src , int target , int k , int threshold , List<Edges>[] graph){
        // we are allowed to vist the visited 

        int dis[] = new int[n];
        Arrays.fill(dis , Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src , 0});

        dis[src] = 0 ; 

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int u = curr[0];
            int heavy = curr[1];

            if(heavy > k) continue;

            for(Edges e : graph[u]){
                int v = e.u;
                int weight = e.weight;

                // if weight <= threhold no changes just put in the the queue
                if(weight <= threshold && dis[v] > heavy){
                    q.offer(new int[]{v, heavy});
                    dis[v] = heavy;
                    
                }
                else if(weight > threshold && dis[v] > heavy + 1){
                    q.offer(new int[]{v , heavy + 1} );
                    dis[v] = heavy + 1;
                }
            }
        }

        // or shoould we just build the dijkstra and at last check 
        if(dis[target] <= k) return true; 
        else return false; 
    }
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        // undirected so a to b and b to a too 
        // edges = u v w -> u and v we know and w is weight 
        // we are also given soure tar and k 

        // a threshold tells us if edge is light of heavy

        // light : weight is <= threshold 
        // heavly > threshold 

        // return min threshold such that at least one valid path exist from src to target 

        // a path is valid if it contains at most k heavy. edges 

        // if we cant reach the path we return -1



        // make the adj list as usual 
        //do the dijkstra from src till the dest ? why do we need dijkstra > cause the there are weights we need the path from src to dest and ?what will the pq do here do we even need pq

        // so take the curr and go to the next take the weight check the threshhold if > do heavey ++ or light ++ if the heavey become > k return false; on binary search on answer 

        // Make the adj list 
        this.n = n;
        List<Edges>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int e[] : edges){
            int u = e[0];
            int v= e[1];
            int w = e[2];

            graph[u].add(new Edges(v , w));
            graph[v].add(new Edges(u , w));
        }

        int left = 0; 
        int right = 1000000000;
        int ans = -1; 

        while(left <= right){
            int mid  = left + (right - left ) / 2 ;

            if(dijkstra(source , target , k , mid , graph )){
                ans = mid ; 
                right = mid -1 ; 
            }
            else {
                left = mid + 1; 
            }
        }

        return ans; 
    }
}