class Solution {
    int profit = 0 ; 
    public int f(int i , int buy , int nums[] , int [][]dp){
        if(i >= nums.length) return 0 ; 

        if(dp[i][buy] != -1 ) return dp[i][buy];
        if(buy == 1) {
            profit = Math.max(- nums[i] + f(i + 1 , 0 , nums , dp) , 
                                f(i + 1 , 1 , nums , dp));
        }
        else {
            profit = Math.max( nums [i] + f (i + 2 , 1 , nums , dp) , 
                            f(i + 1 , 0 , nums , dp));
        }
        return dp[i][buy] =profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int [prices.length][2];
        for(int i = 0; i< prices.length ; i++){
            Arrays.fill(dp[i] , -1 );
        }
        return f(0 , 1 , prices , dp);
    }
}