class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;


        // keep the track of the distance 
        int dis[][] = new int[n][m];

        // check which was visited 
        boolean vis[][] = new boolean [n][m];


        //queue for the bfs 
        Queue<int[]> q = new LinkedList<>();


        // place all the value of the 0s queue and mark them visited 
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(mat[i][j] == 0 ) {
                    q.add(new int[]{i , j });
                    vis[i][j] = true; 
                }
            }
        }

        // for the four operation like up , down , left , right 
        int[] dr = new int[]{-1 , 0 , 1 , 0};
        int[] dc = new int[]{0 , 1 , 0 , -1};

        //remove untill the queue is empty 
        while(!q.isEmpty()){

            // remove the first from the queue and check ther neioubhours
            int curr[] = q.poll();
            // row 
            int r = curr[0];
            //column 
            int c =curr[1];

            // move for each direction like up down left and right 
            for(int k = 0 ; k < 4 ; k++){
                int newR = r + dr[k];
                int newC = c + dc[k];

                // for each direction check the condition and if that cell is visited or not 
                // if the cell is not visited update the distance and mark them as distace if the cell is not visited the distance will + 1 from the preovious 
                if(newR >= 0 && newC >= 0 && newR < n && newC < m && !vis[newR][newC]){

                    dis[newR][newC] = dis[r][c] + 1 ; 
                    vis[newR][newC] = true; 

                    // add the visited cell to the queue to check its neigoubhour 
                    q.add(new int[]{newR, newC});
                }
            }
        }
        // return the answer 
        return dis;
    }
}