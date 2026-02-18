class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length ; 
        int col = grid[0].length ;
        int dp[][] = new int[row][col];

        for(int i =0 ; i< row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(i == 0 && j == 0 ) dp[i][j] = grid[0][0];
                else{
                    int left = 1000000000 ; 
                    int up = 1000000000 ; 
                    if(i > 0){
                        up = grid[i][j] + dp[i-1][j];
                    }
                    if(j>0){
                        left = grid[i][j] + dp[i][j-1];
                    }
                    dp[i][j] = Math.min(up , left);
                }
            }
        }
        return dp[row-1][col-1];
    }
}