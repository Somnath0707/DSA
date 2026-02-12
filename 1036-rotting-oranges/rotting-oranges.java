class Solution {
    public int orangesRotting(int[][] grid) {

        // Length of the row and column 
        int n = grid.length;
        int m = grid[0].length;
        // make a queue for the bfs which store row and column
        Queue<int[]> q = new LinkedList<>();

        // keep count of the fresh
        int fresh = 0;

        //populate the queue

        for(int i = 0 ; i< n ; i++){
            for(int j =0; j < m ; j++){
                // add the rotten oranges to the queue
                if(grid[i][j] == 2){
                q.offer(new int[]{i , j });
                }

                // Keep the count of the fresh oranges
                if(grid[i][j] ==1) fresh ++;
            }
        }

        // If there are no fresh oranges  then grid so then we know all the oranges are already rotten 
        if(fresh ==0 ) return 0; 

        // Count the minutes
        int minutes = 0 ; 

        // Direction to the neighbour

        int[][] direction = {
            {1,0}, // Up
            {-1,0}, // Down 
            {0,1}, // Right 
            {0,-1} // Left 
        };
        

        // Bfs

        while(!q.isEmpty()){

            int size = q.size();
            boolean rottedThisMinute = false;

            for(int i =0 ; i< size ; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] dir : direction){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];


                    if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m &&
                     grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;

                        fresh --; 
                        q.offer(new int[]{newRow , newCol});
                        rottedThisMinute = true; 
                    }
                }
            }
            if(rottedThisMinute == true) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}