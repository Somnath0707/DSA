class Solution {
    public int findMinPath(int row , int col , int[][] nums , int[][] dp){
        if(col<0 || col >= nums[0].length) return 100000000  ; 
        if(row == 0) return nums[0][col];
        if(dp[row][col] != -101) return dp[row][col];

        int up = nums[row][col] + findMinPath(row-1, col , nums ,dp);
        int left = nums[row][col] + findMinPath(row-1, col-1 , nums ,dp);
        int right = nums[row][col] + findMinPath(row -1 , col+1 , nums , dp);

        return dp[row][col] =  Math.min(up , Math.min(left , right ));
    }
    public int minFallingPathSum(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length ; 
        int min = 100000000;
        int dp[][] = new int[row][col];

        for(int i =0 ; i< row ; i++){
            Arrays.fill(dp[i] , -101);
        }
        for(int j =0 ; j < col ; j++){
            min = Math.min(min , findMinPath( row - 1, j, nums , dp));
        }
        return min ;
    }
}