class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        Queue<int []> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 )
                q.offer(new int[]{i , j });
            }
        }

        if(q.isEmpty() || q.size() == m * n ) return -1 ; 

        int dis = -1 ; 
        int dire[][] = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int size = q.size();
            dis ++ ; 

            for(int i = 0 ; i < size ; i++){
                int curr[] = q.poll();

                for(int d[] : dire){
                    int nr = curr[0] + d[0]; 
                    int nc = curr[1] + d[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0){
                        grid[nr][nc] = 1 ; 
                        q.offer(new int[]{nr , nc});
                    }
                }

                
            }
        }
        return dis; 
    }
}