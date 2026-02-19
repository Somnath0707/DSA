class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length;

        int minRow = n ;
        int minCol = m;
        int maxRow = 0 ; 
        int maxCol = 0 ; 
        for(int r = 0 ; r < n ; r++){
            for(int c = 0; c < m ; c++){
                if(grid[r][c] == 1){
                    minRow = Math.min(minRow , r);
                    minCol = Math.min(minCol , c);
                    maxRow = Math.max(maxRow ,r );
                    maxCol = Math.max(maxCol , c);
                }
            }
        }

        int totalRow = maxRow - minRow + 1; 
        int totalCol = maxCol - minCol+ 1; 
        return totalRow * totalCol;
    }
}