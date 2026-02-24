class Solution {
    public int f(int i , int buy , int cap , int nums[] , int dp[][][]){
        if(cap == 0 ) return 0 ; 
        if( i == nums.length ) return 0 ; 
        if(dp[i][buy][cap] != -1 ) return dp[i][buy][cap];

        if( buy == 1 ) {
            return dp[i][buy][cap] = Math.max( -nums[i] + f(i + 1 , 0 , cap , nums , dp), 
                            f(i + 1 , 1 , cap , nums , dp) );
        }
        return dp[i][buy][cap] = Math.max(nums[i] + f( i+ 1 , 1 , cap-1 , nums , dp) , 
                            f(i+ 1 , 0 , cap , nums ,dp));
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int [prices.length][2][k+1];
        for(int i = 0 ; i< prices.length ; i++){
            for(int j = 0; j < 2 ; j++){
                Arrays.fill(dp[i][j] , -1 );
            }
        }
        return f(0 , 1 , k , prices , dp);
    }
}