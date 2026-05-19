class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length;
        
        Deque<int[]> dq = new ArrayDeque<>();

        // distance array
        int dis[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dis[i] , Integer.MAX_VALUE);
        }

        dis[0][0] = 0 ; 
        dq.offerFirst(new int[]{0 , 0});

        // Direction as per question 
        int dir[][] = {
            {0 , 1}, // right 
            {0, -1},// left
            {1 , 0}, // up 
            {-1 , 0} // down 
        };

        while(!dq.isEmpty()){
            int curr[] = dq.pollFirst();
            int row = curr[0];
            int col = curr[1];

            // All four direction 
            for(int k = 0 ; k < 4 ; k++){
                int nr = row + dir[k][0];
                int nc = col + dir[k][1];

                if(nr >= n || nr < 0 || nc >= m || nc < 0 ){
                    continue;
                }
                int wt = 0 ; 
                if(grid[row][col] == k + 1 ){
                    wt = 0 ;
                }else {
                    wt = 1; 
                }


                if(dis[row][col] + wt  < dis[nr][nc]){
                    dis[nr][nc] = dis[row][col] + wt;

                    if(wt == 0){
                        dq.offerFirst(new int[]{nr, nc});
                    }else{
                        dq.offerLast(new int[]{nr, nc});
                    }

                }
            }

        }

        return dis[n-1][m-1];
    }
}