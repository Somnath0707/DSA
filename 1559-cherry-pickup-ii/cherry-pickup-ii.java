class Solution {
    public int findAns(int i , int j1 , int j2  , int row , int c , int[][] nums ,int dp[][][]){
        if(j1 <0 || j1 >= c || j2 <0 || j2 >= c){
            return -100000000;
        }
        if(i == row-1) {
            if(j1 == j2 ) return nums[i][j1];
            else return nums[i][j1] + nums[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // explore all path 
        int maxi = -100000000;
        for(int dj1  = -1 ; dj1<=+1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= +1 ; dj2++){
                int value = 0; 
                if(j1 == j2){
                    value = nums[i][j1];
                }else {
                    value = nums[i][j1] + nums[i][j2];
                }

                value += findAns(i +1 , j1+dj1 ,j2+ dj2 , row , c , nums , dp);
                maxi = Math.max(maxi , value);
            }
        }
        return dp[i][j1][j2] =  maxi;
    }
    public int cherryPickup(int[][] nums) {
        int row = nums.length ; 
        int col = nums[0].length;
        int dp[][][] = new int [row][col][col];

        for(int i =0 ; i < row ; i++){
            for(int j = 0; j < col ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return findAns(0 , 0 , col-1 , row , col, nums , dp);

    }
}