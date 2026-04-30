class Solution {
    int paths = 0;
    int empty = 0;
    int rows, cols;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int startX = 0, startY = 0;

        // count empty cells + find start
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) empty++;
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, startX, startY, -1); // start counts as visited

        return paths;
    }

    public void dfs(int[][] grid, int i, int j, int count){
        // out of bounds or obstacle or visited
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == -1){
            return;
        }

        // reached end
        if(grid[i][j] == 2){
            if(count == empty) paths++; // visited all cells
            return;
        }

        // mark visited
        int temp = grid[i][j];
        grid[i][j] = -1;

        // explore 4 directions
        dfs(grid, i+1, j, count+1);
        dfs(grid, i-1, j, count+1);
        dfs(grid, i, j+1, count+1);
        dfs(grid, i, j-1, count+1);

        // backtrack
        grid[i][j] = temp;
    }
}