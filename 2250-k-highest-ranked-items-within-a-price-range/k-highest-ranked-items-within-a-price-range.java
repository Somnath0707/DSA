class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        /** Requirement : PrirorityQueue(with multiple condition ) , visited Matrix  ,
        List (to sotre the answer in the end */

        // Make a min pq and sort by distance then priceLower , row (lower ) , col low Tie breaker

        // If we land in 0 dont put them in the pq and mark them as visisted 
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[0] != b[0]) return a[0] - b[0];// distance 
            if(a[1] != b[1]) return a[1] - b[1];// price
            if(a[2] != b[2]) return a[2] - b[2];// row 
            return a[3] - b[3];// column
        });

        List<List<Integer>> ans = new ArrayList<>();

        int startRow = start[0];
        int startCol = start[1];
        if(grid[startRow][startCol] == 0 ){
            // while puting in the list we will just ignore the one with value one or should I just make them integerMax
            return ans ;
        }
        pq.offer(new int[]{0 , grid[startRow][startCol] , startRow , startCol});
        vis[startRow][startCol] = true;


        // Here the direction are all the direction ig as it is not mention explictly so I would assume in diagonals too 
        int[][] dir = {
                            {-1, 0},  // up
                            {1, 0},   // down
                            {0, -1},  // left
                            {0, 1},   // right
                        };

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int dis = curr[0];
            int price = curr[1];
            int currRow = curr[2];
            int currCol = curr[3];

            if( ans.size() < k && price != 1 && price >= pricing[0] && price <= pricing[1]){
                ans.add(new ArrayList<>(Arrays.asList(currRow , currCol)));
                if (ans.size() == k) return ans;
            }

            for(int[] d : dir){
                int nr = currRow + d[0];
                int nc = currCol + d[1];
                
                if(nr>= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] != 0 && vis[nr][nc] == false ){
                    pq.offer(new int[]{dis+1 , grid[nr][nc] , nr , nc});
                    vis[nr][nc] = true;
                }
            }
        }
        return ans ; 
    }
}