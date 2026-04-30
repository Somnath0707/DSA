class Solution {
    int paths = 0 ; 
    int empty = 0 ; 
    int rows ; 
    int col ; 

    public void dfs(int i , int j , int grid[][] , int count){
        if(i >= rows || i < 0 ||j >= col || j < 0 || grid[i][j] == -1 ){
            return ; 
        }

        if(grid[i][j] == 2 ) {
            if(count == empty  ) paths++;
            return ; 
        }


        // mark visited 
        int temp = grid[i][j];
        grid[i][j] = -1 ; 

        dfs(i+1 , j , grid , count+ 1 ) ; 
        dfs(i , j+1 , grid , count +1);
        dfs(i-1 , j , grid , count + 1 ) ;
        dfs(i , j-1 , grid , count + 1 );

        grid[i][j] = temp ; 

        

    }
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length ;
        col = grid[0].length ; 

        int startI = 0 ; 
        int startJ = 0 ; 

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 0){
                    empty++;
                }
                if(grid[i][j] == 1){
                    startI = i ; 
                    startJ = j; 
                }
            }
        }

        dfs(startI , startJ , grid , -1);
        return paths; 
    }
}