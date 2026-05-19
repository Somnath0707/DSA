class Solution {
    public int minCost(int[][] grid) {
        // If same side then we do add to front else we add to the back 
        // We increment the distance only if the side changes else we put just 0 side change we put +1 
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int dis[][] = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dis[i] , Integer.MAX_VALUE);
        }

        dis[0][0] = 0 ; 
        dq.offerFirst(new int[]{0 , 0});

        int dir[][] = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        while(!dq.isEmpty()){
            int curr[] = dq.pollFirst();
            int row = curr[0];
            int col = curr[1]; 

            for(int d = 0 ; d < 4 ; d++){
                int nr = row + dir[d][0];
                int nc = col + dir[d][1];

                if(nr >= n || nr < 0 || nc >= m || nc < 0  ){
                    continue;
                }
                // Same direction 
                int wt  =  0 ; 
                if(grid[row][col] == d+1){
                     wt = 0 ; 
                }else{
                    wt = 1 ;
                }

                if(dis[row][col] + wt < dis[nr][nc]){
                    dis[nr][nc] = dis[row][col] + wt;
                    if(wt == 0 )
                    dq.offerFirst(new int[]{nr, nc});

                    if(wt == 1 ){
                        dq.offerLast(new int[]{nr , nc});
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
}