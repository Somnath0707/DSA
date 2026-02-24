class Solution {
    int profit = 0 ; 
    public int f(int i , int buy , int cap , int nums[] , int dp[][][]){
        if(cap == 0 ) return 0 ; 
        if( i == nums.length ) return 0 ; 
        if(dp[i][buy][cap] != -1 ) return dp[i][buy][cap];

        if(buy == 1){
            profit = Math.max(
                -nums[i] + f(i+ 1, 0 , cap , nums , dp),
                0 + f(i + 1 , 1 , cap , nums , dp)
            );
        }
        else {
            profit = Math.max(
                 nums[i] + f(i + 1 , 1 , cap -1 , nums , dp) , 
                 0 + f(i + 1 , 0 , cap , nums ,dp)
            );
        }
        return dp[i][buy][cap] =  profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][][] = new int [prices.length][2][3];
        for(int i = 0 ; i< prices.length ; i++){
            for(int j =0 ; j < 2 ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return f(0 , 1 , 2 , prices , dp);
    }
}