class Solution {
    public int minimumObstacles(int[][] grid) {
        // start from the first cell
        // put that in the queue
        // bfs and if we encounter any 1 we increase the count for that by 1 
        // once we reach the last cell we return the one with the minimhn 
        // So in short bfs 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        int n = grid.length;
        int m = grid[0].length;
        int distance[][] = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(distance[i] , Integer.MAX_VALUE);
        }
        distance[0][0] = grid[0][0];

        pq.offer(new int[]{grid[0][0] , 0 , 0});

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            // if(cost > distance[row][col]) continue;

            if(row == n-1 && col == m-1) return cost ; 

            for(int d[] : dir){
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m  ){
                    int newCost = cost + grid[nr][nc];

                    if(newCost < distance[nr][nc]){
                        distance[nr][nc] = newCost;
                        pq.offer(new int[]{newCost , nr , nc});
                    }
                }
            }
        }
        return -1 ;
    }
}