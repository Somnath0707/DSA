class Solution {
    public int minScore(int n, int[][] roads) {
        
        List<List<int[]>> list = new ArrayList<>(); 

        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<>());
        }

        for(int e[] : roads){
            int u = e[0]; 
            int v = e[1]; 
            int dis = e[2]; 

            list.get(u).add(new int[]{v , dis});
            list.get(v).add(new int[]{u , dis});
        }

        int min[] = new int[n+1];
        Arrays.fill(min , Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] ,b[1]));

        pq.offer(new int[]{1 , Integer.MAX_VALUE });
        boolean vis[] = new boolean[n+1]; 

        min[1] = Integer.MAX_VALUE ; 
        vis[1] = true; 

        while(!pq.isEmpty()){
            int curr[] = pq.poll(); 
            int node = curr[0]; 
            int currMin = curr[1];

            for(int next[] : list.get(node)){
                int nextNode = next[0]; 
                int nextMin = next[1]; 

                int newMin = Math.min(nextMin , currMin);

                if(min[nextNode] <= newMin ) continue; 

                min[nextNode] = newMin;
                pq.offer(new int[]{nextNode , newMin});
                vis[nextNode] = true; 
            }
        }

        return min[n]; 
    }
}

//  n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]