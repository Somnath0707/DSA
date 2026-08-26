class Solution {
    int MOD = 1000000007; 
    public int countPaths(int n, int[][] roads) {
        // first I need to find the shortest path from 0 to n-1
        // once I had shortest path then I have to see how many of these guys have that shoretst path 

        // so we can have dist array with states like first pos with time and then how many 

        // suppose i reach there how many have reach at that time till that 

        // suppose dis[][2] -> first is for the minTime and next is for total number of people reached there 

        // or like we can store if the curr time is same as the least than we can do is remove suppose it was 9 and 2 first and if 7 comes then answer comes 7 and 1 if again 7 then update if less update if > do nothing 


        // at the end return dis[n-1][2]; 
        List<List<int[]>> list = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>()); 
        }

        for(int e[] : roads){
            int u = e[0]; 
            int v = e[1]; 
            int time = e[2]; 

            list.get(u).add(new int[]{v , time});
            list.get(v).add(new int[]{u , time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        long dist[][] = new long[n][2]; 
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i] , Long.MAX_VALUE); 
        }
        pq.offer(new long[]{0 , 0 });
        dist[0][0] = 0 ; 
        dist[0][1] = 1 ; 


        while(!pq.isEmpty()){
            long curr[] = pq.poll(); 
            int u = (int)curr[0]; 
            long currTime = curr[1];

            for(int temp[] : list.get(u)){
                int nextNode = temp[0]; 
                int nextTime = temp[1]; 

                long newTime = currTime + nextTime; 
                if(dist[nextNode][0] > newTime){
                    dist[nextNode][0] = newTime;
                    dist[nextNode][1] = dist[u][1] ; 
                    pq.offer(new long[]{nextNode , newTime});
                }
                else if(dist[nextNode][0] == newTime){
                    dist[nextNode][1] = (dist[nextNode][1]%MOD + dist[u][1] %MOD)% MOD; 
                    // do I have to offer it to pq probalbly not 
                }
            }
        }



        return (int)dist[n-1][1]; 


    }
}