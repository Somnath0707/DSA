class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        // we have 0 to n-1 , we are given 2d array edges indicates there is a message channel between server and the can passs any number of messages to each other directly in one second  we also have an patience array of length n 

        // all server are connected i.e. a msg can be passed from one server to any other servers directly or indirectly thorugh the msg channels 

        // The server 0 is master . The rest are date server. each server needs to send it to the master 

        // find the shorest distance from each node to 0 first 
        // for each operation on see the patience then do like 2 * shorest distance + last message sent by the 0 which would be if 2 and 6 then last would be 4 so 4+ 6  = 10
        // 3 and 6 0 3 6 
        
        List<List<Integer>> list = new ArrayList<>(); 
        int n = patience.length ; 
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>()); 
        }

        for(int num[] : edges){
            int u = num[0]; 
            int v = num[1]; 
            list.get(u).add(v); 
            list.get(v).add(u); 
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1])); 

        pq.offer(new int[]{0 ,0});
        int dist[] = new int[n]; 
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0 ; 

        while(!pq.isEmpty()){
            int curr[] = pq.poll(); 
            int val = curr[0]; 
            int currDist = curr[1]; 

            for(int num : list.get(val)){

                int newDist = currDist + 1; 
                if(newDist < dist[num]){
                    dist[num] = newDist; 
                    pq.offer(new int[]{num , newDist});
                }
            }
        }


        int m = patience.length; 
        int ans = Integer.MIN_VALUE ; 
        for(int i = 1 ; i < m ; i++){
            int curr = patience[i]; 
            int maxDist = 2 * dist[i]; 
            // if(maxDist < curr) ans = Math.max( maxDist , ans); 
            int lastMessage = ((maxDist -1) /curr)* curr + maxDist ;
            ans = Math.max(lastMessage , ans);
        }

        return ans+1; 
    }
}