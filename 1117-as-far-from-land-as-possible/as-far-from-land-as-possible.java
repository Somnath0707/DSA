class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length ; 
        int m = grid[0].length ; 

        for(int i = 0; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 ){
                    q.offer(new int[]{i , j });
                }
            }
        }

        // if all 1s 
        if(q.isEmpty() || q.size() == m * n ) return -1;

        int dis = -1 ; 
        int dire[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            dis++;

            for(int i = 0 ; i < size ; i++){
                int curr[] = q.poll();

                for(int d[] : dire){
                    int newRow = curr[0] + d[0];
                    int newCol = curr[1] + d[1];


                    if(newRow < n && newCol < m && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] == 0){
                        grid[newRow][newCol] = 1 ; 
                        q.offer(new int[]{newRow , newCol});

                    }
                }
            }
        }
        
        return dis ; 
    }
}

// from each 0 count the min distace to the nearest 1 
// keep the track of that min for all the 0 
// iteretae through all the cells and get the distance that is min for that and compare that globally 
// at end return ans 