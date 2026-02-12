class Solution {

    public void dfs(int row , int column , int newColor , int initialImage , int[][] image , int [][] ans){
        int n = image.length;
        int m = image[0].length;
        
        if(row < 0 || column < 0 || row >= n || column >= m ) return ; 

        if(image[row][column] != initialImage) return ; 

        if (ans[row][column] == newColor)
            return;

        ans[row][column] = newColor;
        dfs(row + 1 , column , newColor , initialImage , image , ans);
        dfs(row -1 , column , newColor , initialImage , image , ans);
        dfs(row  , column+1 , newColor , initialImage , image , ans);
        dfs(row , column-1 , newColor , initialImage , image , ans);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialImage = image[sr][sc];
        int n = image.length ; 
        int m = image[0].length ;
        int[][] ans = new int[n][m];

        // Copy original image into ans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = image[i][j];
            }
        }

        dfs(sr , sc , color , initialImage , image , ans );
        return ans;
    }
}