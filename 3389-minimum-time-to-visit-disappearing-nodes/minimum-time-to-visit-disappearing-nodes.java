class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        
        List<List<int[]>> list =  new ArrayList<>();

        for(int i = 0 ; i <n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i =0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1]; 
            int time = edges[i][2]; 

            list.get(u).add(new int[]{v , time});
            list.get(v).add(new int[]{u , time});
        }

        int dis[] = new int[n];

        Arrays.fill(dis , Integer.MAX_VALUE);

        dis[0] = 0 ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int u = curr[0];
            int time = curr[1]; 

            if(time > dis[u]) continue; 
            
            if(disappear[u] <= time){
                continue; 
            }

            for(int num[] : list.get(u)){
                int next = num[0];
                int nextTime = num[1]; 

                int newTime = nextTime+ time; 
                if(disappear[next] <= newTime){
                    continue; 
                }

                if(dis[next] > newTime){
                    dis[next] = newTime; 
                    pq.offer(new int[]{next , newTime});
                }
            }
        }

        for(int i = 0 ; i <n ; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1 ; 
            }
        }

        return dis; 
    }
}