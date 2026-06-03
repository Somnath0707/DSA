class Solution {
    public int minTime(int n, int[][] edges) {
        // wee use the dijkstra instead of the distance we store the time required to reach that node 

        // so dijkstra we will need heap 
        // to visit the next node we need the starttime of next node + 1 to reach there 

        // if we are already greater than that no need 

        // make the adj list are this is the directed grpah we can make the adj list 
        // keep track of the visited node 


        // so the time at node 0 if the start time is 0 and end is 2 should be 0 , 1 , 2 if this is the first node we will need t =1 to reach here which is start + 1 

        // we could add condtion like if current time is between the limit we can start if is less we can wait to start 
        // but if the time has already exceeded we cnat do shit
        List<List<int[]>> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0]; 
            int v = edges[i][1] ; 
            int start = edges[i][2]; 
            int end = edges[i][3];

            list.get(u).add(new int[]{v , start , end});
        }


        int dis[] = new int[n]; 
        Arrays.fill(dis , Integer.MAX_VALUE ) ; 
        dis[0] = 0 ; 

        PriorityQueue<int[]> pq  = new PriorityQueue<>((a,b)-> a[1] - b[1]); 

        // the pq has the node and the time of arrival 
        pq.offer(new int[]{0 , 0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int v = curr[0]; 
            // int arrival time of that noe 
            int arriv = curr[1]; 
            if(arriv > dis[v]) continue;

            for(int nums[] : list.get(v)){
                int nextNode = nums[0]; 
                int tStart = nums[1];
                int tEnd = nums[2]; 
                int nextTime = 0 ; 

                if(arriv >= tStart &&  arriv <= tEnd){
                    nextTime = arriv + 1; 
                }
                else if(arriv < tStart ) {
                    nextTime = tStart + 1 ;
                }
                else{
                    continue;
                }

                if(dis[nextNode] > nextTime ){
                    dis[nextNode] = nextTime; 

                    pq.offer(new int[]{nextNode , nextTime});
                }

            }
        }




        



    
    return (dis[n-1] == Integer.MAX_VALUE ? -1 : dis[n-1]);



    }
}