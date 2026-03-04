class Solution {

    public void dfs(int i , int j , int [][] grid , int [][] vis , int[] delRow , int[] delCol){
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] = 1; 

        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];

            if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m 
                && vis[newRow][newCol] == 0  && grid[newRow][newCol] == 1){
                dfs(newRow , newCol , grid , vis , delRow , delCol ) ; 
            }
        }
    }


    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = new int[]{-1 , 0 , 1 , 0 };
        int [] delCol = new int[]{0 , 1 , 0 , -1 };

        int[][] vis = new int[n][m];

        // get the 1s on the row 

        for(int j = 0 ; j < m ; j++){

            // for the first row 
            if(grid[0][j] == 1 && vis[0][j] == 0 ){
                dfs(0 , j  , grid , vis , delRow , delCol);
            }

            //for the last row 
            if(grid[n-1][j] == 1 && vis[n-1] [j] == 0 ){
                dfs(n-1 , j , grid , vis , delRow , delCol);
            }
        }


        // traverse the first and last  column 
        for(int i =0 ; i < n ; i++){
            
            // for the first column 
            if(grid[i][0] == 1 && vis[i][0] == 0 ){
                dfs( i , 0 , grid , vis , delRow , delCol);
            }

            // for the last column 
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0 ){
                dfs(i , m-1 , grid , vis , delRow , delCol);
            }
        }

        // count all the 1s in the middle 

        int count = 0; 
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == 1&& vis[i][j] == 0 ) {
                    count++;
                }
            }
        }
        return count; 
    }
}


// mark all the one on the boundry and those who are conntect to the once to boundary and then 
// check for the gird if the cell is not marked is a land sell count ++ ; 