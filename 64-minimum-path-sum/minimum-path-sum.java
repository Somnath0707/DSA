class Solution {
    public int findPath(int row , int col , int[][] grid ,int dp[][] ){
        if( row ==0 && col == 0 ) return grid[0][0];

        if(row < 0 || col < 0) return 1000000000;

        if(dp[row][col] != -1) return dp[row][col];

        int up = grid[row][col] + findPath(row-1 , col , grid , dp);
        int left = grid[row][col] + findPath(row,col-1 , grid , dp);
        return dp[row][col] = Math.min(up , left);
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length ; 
        int col = grid[0].length ;
        int dp[][] = new int[row][col];
        for(int i =0; i < row ; i++){
            Arrays.fill(dp[i] , -1);
        } 

       return findPath(row-1 , col -1, grid,dp );
    }
}