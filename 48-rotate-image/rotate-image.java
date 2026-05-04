class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length;
        int ans[][] = new int[n][m];

        int indxR = 0 ; 
        int indxC = 0 ; 
        for(int i = n -1 ; i >= 0 ; i--){
            for(int j = 0 ; j < m ; j++){
                ans[indxR][indxC] = matrix[i][j];
                indxR++;
            }
            indxR = 0 ;
            indxC++;
        }
        for(int i = 0 ;  i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                matrix[i][j] = ans[i][j];
            }
        }
        return ;
    }
}