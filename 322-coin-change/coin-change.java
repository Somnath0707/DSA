class Solution {
    public int f(int n , int[] coins , int amount , int[][]dp){
        if(n == 0 ){
            if(amount % coins[0] == 0) return amount/coins[0];
            else return Integer.MAX_VALUE /2; 
        }
        if(dp[n][amount] != -1) return dp[n][amount];
        int notTake = 0 + f(n-1 , coins , amount  , dp);
        int take = Integer.MAX_VALUE /2;
        if(coins[n] <= amount) take = 1 + f(n , coins , amount - coins[n] ,dp);

        return dp[n][amount] = Math.min(notTake , take );
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        int[][] dp = new int[n][amount+1];

        for(int i =0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int ans = f(coins.length -1  , coins , amount ,dp );

        if(ans >= Integer.MAX_VALUE /2)return -1;
        return ans;
    }
}