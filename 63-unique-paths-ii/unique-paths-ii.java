class Solution {
    public int findPath (int row , int col , int [][]obstacleGrid , int[][] dp ){
        if(row ==0 && col == 0 && obstacleGrid[row][col] != 1) return 1;
        if(row < 0 || col < 0 ) return 0 ; 
        if(obstacleGrid[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int up = findPath(row-1, col , obstacleGrid , dp);
        int left = findPath(row , col-1 ,obstacleGrid , dp);
        return dp[row][col] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length ; 
        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return findPath(row-1 , col-1 , obstacleGrid, dp);
    }
}