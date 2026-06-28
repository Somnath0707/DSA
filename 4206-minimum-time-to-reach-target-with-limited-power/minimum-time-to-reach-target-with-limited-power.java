class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<List<int[]>> list = new  ArrayList<>(); 
        for(int i = 0 ; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int num[] : edges){
            int u = num[0]; 
            int v = num[1]; 
            int time = num[2];

            list.get(u).add(new int[]{v , time});
        }
        

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0])return  Long.compare (a[0] , b[0]); 
            return Long.compare(b[2],a[2]);
        });

        pq.offer(new long[]{0 , source , power});
        int m = edges.length ;
        long dist[][] = new long[n][power + 1 ];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(dist[i] , Long.MAX_VALUE);
        }
        dist[source][power] = 0 ; 

        while(!pq.isEmpty()){
            long curr[] = pq.poll();

            long currTime = curr[0]; 
            int currNode = (int)curr[1];
            int currPower =(int) curr[2] ;

            if(dist[currNode][currPower] < currTime) continue ;

            for(int num[] : list.get(currNode)){
                int nextNode = num[0]; 
                long nextTime = num[1]; 

                if(currPower < cost[currNode]) continue; 

                int newPower = currPower - cost[currNode ];
                long newTime = currTime + nextTime; 

                if(newTime < dist[nextNode][newPower]){
                    dist[nextNode][newPower] = newTime; 
                    pq.offer(new long[]{newTime , nextNode , newPower});
                }
            }
        }

        long bestTime = Long.MAX_VALUE;

        long bestPower = -1 ; 
        for(int i = 0 ; i <= power ; i++){

            if(dist[target][i] == Long.MAX_VALUE) continue; 

            if(dist[target][i] < bestTime){
                bestTime = dist[target][i]; 
                bestPower = i ; 
            }

            else if(dist[target][i] == bestTime){
                bestPower = Math.max(bestPower , (long)i);
            }
        }

        if(bestTime == Long.MAX_VALUE) return new long[]{-1,-1};

        return new long[]{bestTime , bestPower};
        
    }
}