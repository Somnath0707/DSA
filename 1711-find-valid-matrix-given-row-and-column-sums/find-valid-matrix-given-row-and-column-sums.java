class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        //
        int n = rowSum.length; 
        int m = colSum.length; 
        int ans[][] = new int[n][m]; 

        // for row 
        for(int i = 0 ; i < n ; i++){
            int sum = 0 ; 
            for(int j = 0 ; j < m ; j++){
                int colTotal = colSum[j]; 
                int need = rowSum[i] - sum;
                int add = Math.min(need , colTotal);
                sum+= add; 
                colSum[j] -= add; 
                ans[i][j] = add; 
                if( sum == rowSum[i]) break ; 
            }
        }

        return ans;
    }
}