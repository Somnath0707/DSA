class Solution {
    public int findPath(int row , int col , int[][] dp){
        if(row == 0 && col == 0 ) {
            return 1;
        }
        if(row < 0 || col < 0 ) {
            return 0 ; 
        }
        if(dp[row][col] != -1) return dp[row][col];

        int up = findPath(row-1 , col, dp);
        int left = findPath(row , col-1 , dp);

        return dp[row][col]= up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i =0 ; i< m ; i++){
            Arrays.fill(dp[i], -1);
        }
        return findPath(m-1 , n-1 , dp);
    }
}