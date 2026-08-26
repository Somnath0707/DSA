class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        int n = grid.length; 
        int dist[][] = new int[n][n]; 

        for(int i =0 ; i < n ; i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }

        int currVal = grid[0][0]; 
        pq.offer(new int[]{0 , 0 , currVal});
        dist[0][0] = currVal; 
        int dir[][] = {
            {1 , 0},
            {0 ,1},
            {-1,0}, 
            {0 , -1}
        };
        while(!pq.isEmpty()){
            int curr[] = pq.poll(); 
            int row = curr[0]; 
            int col = curr[1]; 
            int currDist = curr[2]; 

            for(int d[] : dir){
                int nr = row+d[0]; 
                int nc = col + d[1]; 

                if(nr >= 0 && nc >= 0 && nc < n && nr < n){
                    int newDist = Math.max(currDist , grid[nr][nc]);
                    if(dist[nr][nc] > newDist){
                        dist[nr][nc] = newDist; 
                        pq.offer(new int[]{nr , nc , newDist});
                    }
                }
            }
        }

        return dist[n-1][n-1]; 
    }
}