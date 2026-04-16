class Solution {
    int dp[][][];
    public int f(int i , int j , int cost , int k , int grid[][]){

        
        int n = grid.length ; 
        int m = grid[0].length ;
        
        // Check if the i or j is not out of the bound
        if (i >= n || j >= m) return -1; 

        // Make sure that the current cost + prevCost does not excced the k
        int currCost = 1; 
        if(grid[i][j] == 0) currCost = 0 ; 
        int newCost = cost + currCost;
        // If it excced k we return -1
        if(newCost > k ) return -1;

        // If we are on the last cell get that value 
        if(dp[i][j][newCost] != -2 ) return dp[i][j][newCost];


        if(i == n-1 && j == m -1) return dp[i][j][newCost] = grid[i][j] ; 

        
        

        
        
        
        // Right and down 
        int right = f(i , j+1 , newCost , k , grid);
        int down =  f(i + 1 , j , newCost ,k , grid );

        // Check if the rigth or down are not -1 if so no need to update them 
        if(right != -1) right += grid[i][j];
        if(down  != -1) down  += grid[i][j];

        // Return the max between them under the constrain
        int ans = Math.max(right , down);

        return dp[i][j][newCost] = ans ; 
    }
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length , m = grid[0].length ; 
        dp = new int[n][m][k+1];
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j <m ; j++){
                Arrays.fill(dp[i][j] , -2);
            }
        }
        return f(0 , 0 , 0 , k , grid );
    }
}

// keep the track of all the ways that is the rigth and left too 
// but we have to find something that have less cost or equal to the k 
// Its dp for sure lets see how 


// 0 1 
// 2 0 
//   Try the right and down both and keep doing it if the cost of any become > k then we make that value as the -1 
//   else we keep it as same at the end take the Math.max ( right , down )
  // base condtion will be if we reach the > n-1 , m-1 we return 0 or cost > k = -1 
//   The function should have like i , j , cost 
// Left and Right should store the score and if the cost goes K > then we can just put that as -1 
  // we use the take right and take down as two each should 

// the above example the 0 cost = f(0 , 0 , 0 )
// then right and down 
// for each if the grid[i][j] == 1 || 2 then curr Cost = 1 else new cost = 0 
// for the right = i , j+1 , cost + curr cost 
// for the down = i + 1 , j , cost + curr cost 

// Return min (right , down );