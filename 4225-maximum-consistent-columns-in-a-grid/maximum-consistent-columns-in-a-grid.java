class Solution {
    int dp[]; 
    public boolean canConnect(int curr , int next , int[][] grid , int limit ){
        for(int row = 0 ; row < grid.length ; row ++){
            if(Math.abs(grid[row][curr] - grid[row][next]) > limit) {
                return false; 
            }
        }
        return true; 
    }
    public int f(int i , int[][]grid , int limit){
        if( i == grid[0].length-1 ) return 1 ; 

        if(dp[i] != -1 ) return dp[i]; 

        int ans = 1 ; 

        for(int next = i+1 ; next < grid[0].length ; next ++ ){
            if(canConnect(i,next, grid , limit)){
                ans = Math.max(ans , 1 + f(next , grid , limit));
            }
        }

        return dp[i] = ans; 
        
    }
    public int maxConsistentColumns(int[][] grid, int limit) {
        // [[1,-1,1],[2,2,2]]
        dp = new int[grid[0].length];

        Arrays.fill(dp , -1 );
        


        // 1 -1  1
        // 2  2  2
        int ans = 1 ; 
        for(int i = 0 ; i < grid[0].length ; i++){
            ans = Math.max(ans , f(i, grid , limit));
        }
        return ans;
    }
}