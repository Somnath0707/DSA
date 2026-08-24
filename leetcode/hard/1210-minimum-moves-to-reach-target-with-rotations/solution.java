class Solution {
    public int minimumMoves(int[][] grid) {
        // it doesnt seem to be that hard we can do is move in few direction extra which are left , right , up , down and the clock wise and anticlock wise so we can configure this in the direction array maybe havent thought of it as of now 
        // if any of these direction give us the 1 we dont go that way 
        // we need the shortest distance is it dijkstra then 
        // n < 100 is give away to do bfs or dijkstra I havent done dijkstra in while I will do it ig then 

        // thing we have to rember is that 
        // well we dont even need dijkstra too ig 
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();

        // int vis[][] = new int[n][n]; //will this work how but we dont want to rember that if the that cell is visited we have to see if the snake was in that pos 

        Set<String> set = new HashSet<>();
        String vis = 0 + "#" + 0 + "#" + 0 + "#" + 1 ;
        q.offer(new int[] { 0, 0, 0, 1, 0 });
        set.add(vis);

        int[][] dir = {
                { 1, 0, 1, 0 }, // down
                { 0, 1, 0, 1 }, // right

                // horizontal -> vertical
                { 0, 0, 1, -1 }, 

                { 0, 0, -1, 1 }// rotate right
        };


        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int curr[] = q.poll(); 
            int row1 = curr[0]; 
            int col1 = curr[1]; 
            int row2 = curr[2]; 
            int col2 = curr[3]; 
            int dist = curr[4]; 

            if(row1 == n-1 && col1 == n-2 && row2 == n-1 && col2 == n-1){
                return dist; 
            }

            for(int i = 0 ; i < dir.length ;i++){
                boolean isHor = false ; 
                if(row1 == row2) isHor = true; 
                // if curr is not one of the traditional direction 
                if(i >= 2){
                    //if curr is horizontal and and i >= 6 the side check ver to horz so continue
                    if(isHor && i == 3) continue; 
                    // if curr is ver and the we are on the hor then continue 
                    if(!isHor && i == 2) continue; 
                }

                int newRow1 = row1 + dir[i][0]; 
                int newCol1 = col1 + dir[i][1];  
                int newRow2 = row2 + dir[i][2];
                int newCol2 = col2 + dir[i][3]; 

                // both the row and col should not be the 0 or > n but the second colum should be n-2 only and the value at each should be 0 
                if(newRow1 < 0 || newRow2 < 0 || newCol1 < 0 
                || newRow1 >= n || newRow2 >= n || newCol1 >= n || newCol2 >= n) continue; 

                if(grid[newRow1][newCol1] == 1 || grid[newRow2][newCol2] == 1) continue; 

                if(i == 2 && grid[row1 +1][col1+1] == 1 ) continue; 
                if(i == 3 && grid[row1 +1][col1+1] == 1 ) continue;

                String str = newRow1 + "#" + newCol1 + "#" + newRow2 + "#" + newCol2; 
                if(!set.contains(str)){
                    set.add(str); 
                    int newDist = dist + 1; 
                    q.offer(new int[]{newRow1 , newCol1 , newRow2 , newCol2 , newDist});
                }
            }
        }

        return -1;
        // we can hash but that would be expensive 
    }
}