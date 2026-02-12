class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        
        int fresh = 0; 

        for(int i = 0 ; i< n ; i++){
            for(int j =0 ; j < m ; j++){
                
                if(grid[i][j] == 2){
                    q.offer(new int[]{i , j });
                }

                if(grid[i][j] == 1) fresh ++;
            }
        }

        if(fresh ==0 ) return 0;

        int minutes = 0;


        int dir[][] = {{1,0} , {-1,0},{0,1}, {0,-1}};

        while(!q.isEmpty()){

            int size = q.size();
            boolean rottedThisMinute = false;

            for(int i =0 ; i< size ; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] d : dir){
                    int newRow = row + d[0];
                    int newCol = col+d[1];

                    if(newRow >= 0 && newCol>= 0 
                    && newRow < n && newCol < m && 
                    grid[newRow][newCol] ==1 ){

                        grid[newRow][newCol] = 2;
                        fresh --;
                        q.offer(new int[]{newRow, newCol});
                        rottedThisMinute = true;
                    }
                }
            }
            if (rottedThisMinute) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}