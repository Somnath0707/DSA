class Solution {

    public int f(int n , int target , int nums[] , int [][] dp){
        if(target == 0 ) return 1 ; 
        if(n == 0 ){
            if(target % nums[n] == 0 ) return 1;
            else return 0 ; 
        }
        if(dp[n][target] != -1) return dp[n][target];
        int notTake = f(n-1 , target , nums , dp);
        int take = 0; 
        if(nums[n] <= target ){
            take = f(n , target - nums[n] , nums ,dp);
        }

        return dp[n][target] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length ;
        int dp[][] = new int[n][amount+1];
        for(int i = 0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return f(n-1 , amount , coins ,dp);
    }
}