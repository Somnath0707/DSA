class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dis[][] = new int[n][m];

        boolean vis[][] = new boolean [n][m];

        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(mat[i][j] == 0 ) {
                    q.add(new int[]{i , j });
                    vis[i][j] = true; 
                }
            }
        }


        int[] dr = new int[]{-1 , 0 , 1 , 0};
        int[] dc = new int[]{0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c =curr[1];

            for(int k = 0 ; k < 4 ; k++){
                int newR = r + dr[k];
                int newC = c + dc[k];

                if(newR >= 0 && newC >= 0 && newR < n && newC < m && !vis[newR][newC]){

                    dis[newR][newC] = dis[r][c] + 1 ; 
                    vis[newR][newC] = true; 

                    q.add(new int[]{newR, newC});
                }
            }
        }
        return dis;
    }
}