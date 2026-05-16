class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][][] = new boolean[n][m][k+1];
        vis[0][0][k] = true;
        // row , column , k , dis
        int cur = grid[0][0];
        if(cur == 1){
            k--;
        }
        q.offer(new int[]{0 , 0 , k , 0 });

        int dir[][] = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];
            int remK = curr[2];
            int dis = curr[3];


            // if(remK < 0) continue;
            if(row == n-1 && col == m-1) return dis;

            for(int d[] : dir){
                int nr = d[0] + row;
                int nc = d[1] + col;

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){

                    int newRem = remK;

                    if(grid[nr][nc] == 1){
                        newRem--;
                    }


                    if(newRem >= 0 && !vis[nr][nc][newRem]){
                        vis[nr][nc][newRem] = true;
                        int newDist = dis + 1 ; 

                        q.offer(new int[]{nr , nc , newRem , newDist});
                    }
                }
            }
        }

        return -1; 
    }
}