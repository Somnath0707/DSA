class Solution {
    public int shortestBridge(int[][] grid) {
        // 0 1 0 
        // 0 0 0 
        // 0 0 1 answer 2

        // 1 1 1 1 1 1 
        // 1 0 0 0 0 1
        // 1 0 1 1 0 1 
        // 1 0 0 0 0 1

        Queue<int[]> queue = new LinkedList<>(); 
        int r = 0 ; 
        int c  = 0 ; 
        int n = grid.length; 
        // find the first row and col where there one appear 
        for(int i = 0; i < n ; i++){
            int flag = 0  ;
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                   r = i ; 
                   c = j ; 
                   flag = 1; 
                    break; 
                }
                if(flag == 1 ) break ;
            }
        }

        // bfs to visit that island completly so that we can use that furteher 

        // vis array to keep the track of the visited in the intital bfs 
        int vis[][] = new int[n][n]; 
        // add the first 1s that we got in the above for loop 
        queue.offer(new int[]{r , c});
        // Mark them as visited 
        vis[r][c] = 1; 
        // direction to traverse in 4 direction that is up , down , left , right 
        int dir[][] = {{1 , 0} , {-1,0} , {0,1},{0,-1}};

        Queue<int[]> q = new LinkedList<>(); 

        // to put all the value of 1 that is complete island in the bfs queue
        while(!queue.isEmpty()){
            int curr[] = queue.poll(); 
            int row = curr[0]; 
            int col = curr[1]; 
            int cost = 0 ; 
            q.offer(new int[]{row , col , 0 });
            for(int d[] : dir){
                int nr = row + d[0]; 
                int nc = col + d[1]; 

                if(nr >= 0 && nc < n && nc >= 0 && nr < n && grid[nr][nc] == 1 && vis[nr][nc] == 0 ){
                    queue.offer(new int[]{nr , nc });
                    vis[nr][nc] = 1 ;
                }
            }
        }

        /// the above code is wrong that do not give me complete island should we make one more queue lmao i guess we have to 

        // Now this is the shortest distance is currentyly max 
        int shortest = Integer.MAX_VALUE;
        while(!q.isEmpty()){

            int curr[] = q.poll();
            int row = curr[0]; 
            int col = curr[1]; 
            int cost = curr[2] ; 

            for(int d[] : dir){
                int nr = row + d[0] ; 
                int nc = col + d[1]; 

                // if we arrive at next valid grid that is not of the first island 
                if(nr >= 0 && nc < n && nr < n && nc >= 0 && vis[nr][nc] == 0 ){

                    // here we have landed in the 1 that was not already visted that tells us that this must be the seperate island 
                    if(grid[nr][nc] == 1){
                        // we add the cost +1 as we reach that island no need to add that in queue why idk what would be that benifical for ? 
                        int temp = cost ; 
                        shortest = Math.min(shortest , temp );
                    }
                    else {
                        // else we are at 0 so that means we are trying to swim to next island we incrase the cost one by one for each 
                        if(grid[nr][nc] == 0 ){
                            int newCost = cost + 1; 
                            q.offer(new int[]{nr,nc , newCost});
                            vis[nr][nc] = 1 ; 
                        }
                    }
                }
            }
        }

        return shortest ; 

    }
}