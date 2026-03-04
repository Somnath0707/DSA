class Solution {

    public void dfs(int row , int col  , char[][] board , int vis[][] , int [] delRow , int[] delCol){
        int n = board.length;
        int m = board[0].length;

        vis[row][col] = 1 ; 

        for(int k = 0 ; k < 4 ; k++){
            int newRow = row + delRow[k];
            int newCol = col + delCol[k];

            if( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && vis[newRow][newCol] == 0 && board[newRow][newCol] == 'O'){
                dfs(newRow , newCol , board , vis , delRow ,delCol);
            }
        }
    }


    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int delRow[] = new int[] { -1 , 0 , 1 , 0 };
        int delCol[] = new int[] { 0 , 1 , 0 , -1};

        int vis[][] = new int[n][m];

        //traverse first and last  row 

        for(int j = 0 ; j < m ; j++){

            //first row
            if(board[0][j] == 'O' && vis[0][j] == 0 ){
                dfs(0 , j , board , vis  , delRow , delCol );
            }

            // last row 
            if(board[n-1][j] == 'O' && vis[n-1][j] == 0 ) {
                dfs(n-1 , j , board , vis , delRow , delCol ) ; 
            }

        }

        //traverse the first and last column 

        for(int i = 0 ; i < n ; i++){
            
            // for first column 
            if(board[i][0] == 'O' && vis[i][0] == 0 ) {
                dfs(i , 0 , board , vis , delRow , delCol );
            }

            // last column 
            if(board[i][m-1] == 'O'&& vis[i][m-1] == 0 ) {
                dfs(i , m-1 , board , vis , delRow ,delCol);
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}