class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        // color by one first then check do by the other location if the distance < than prev we color by the current which has lower color if the distance is same we take with the higher value

        // new 2d graph to store the ans or the colored version 
        int [][] ans = new int[n][m];

        // Basic graph pq with the sort dis by ascending and then color by descending 

        // As mentioned in the question that the closed gets the color and the if same the tie breaker is the color number 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });


        // Put the given colored version to start the coloring 
        for(int[] s : sources){
            pq.offer(new int[]{0 , s[2] , s[0] , s[1]});
        }

        // direcion to move up down left right 
        int dirs[][] = {{0 , 1} , {0 , -1 } , {1 , 0}  , { -1 , 0}};


        // Normal graph stuff
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            // get the curr distance
            int dis = curr[0];
            // get the current color 
            int color = curr[1];
            // Self explanatory 
            int row = curr[2];
            int col = curr[3];

            // This tells that we have colred this with the lower dis or the higher color
            if(ans[row][col] !=0 ) continue; // already colored 
            // If the cell is not already colored we color it now 
            ans[row][col] = color;

            // no check for the direction and put the new in the pq 
            for(int[] dir : dirs){
                int newR = row + dir[0];
                int newC = col + dir[1];
                if(newR >= 0 && newR < n && newC >= 0 && newC < m && ans[newR][newC] == 0) {
                    pq.offer(new int[]{dis+1 , color , newR , newC});
                }
            }
        }
        return ans ; 
        
    }
}