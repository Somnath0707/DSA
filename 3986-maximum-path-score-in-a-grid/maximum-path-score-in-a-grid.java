class Solution {
    int[][][] dp;

    public int f(int i , int j , int cost , int k , int grid[][]){

        int n = grid.length ; 
        int m = grid[0].length ;
        
        if (i >= n || j >= m) return -1; 

        int currCost = (grid[i][j] == 0) ? 0 : 1;
        int newCost = cost + currCost;

        if(newCost > k ) return -1;

        if(dp[i][j][newCost] != -2) return dp[i][j][newCost];

        if(i == n-1 && j == m -1) {
            return dp[i][j][newCost] = grid[i][j];
        }

        int right = f(i , j+1 , newCost , k , grid);
        int down  = f(i + 1 , j , newCost , k , grid );

        if(right != -1) right += grid[i][j];
        if(down  != -1) down  += grid[i][j];

        int ans = Math.max(right , down);

        return dp[i][j][newCost] = ans;
    }

    public int maxPathScore(int[][] grid, int k) {
        
        int n = grid.length, m = grid[0].length;

        k = Math.min(k, n + m); // small optimization

        dp = new int[n][m][k+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int c = 0; c <= k; c++){
                    dp[i][j][c] = -2; // unvisited
                }
            }
        }

        return f(0 , 0 , 0 , k , grid );
    }
}