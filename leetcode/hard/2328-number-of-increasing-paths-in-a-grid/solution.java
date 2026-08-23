class Solution {
    int dir[][] = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

    int MOD = 1000000007; 
    Integer dp[][]; 

    public int f(int i  , int j , int grid[][] , int n , int m){
        if(dp[i][j] != null) return dp[i][j]; 
        int total = 1 ; 
        for(int d[] : dir){
            int nr = i + d[0]; 
            int nc = j + d[1]; 

            if(nr >= 0 && nr< n && nc >= 0 && nc < m && grid[i][j] < grid[nr][nc]){
                total = (total + f(nr , nc , grid , n , m)) % MOD;
            }
        }

        return dp[i][j] = total ;
    }
    public int countPaths(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ;
        dp = new Integer[n][m];  
        int total = 0 ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                total = (total + f(i , j , grid , n , m)) % MOD ;
            }
        }
        return total;
    }
}