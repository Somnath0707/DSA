class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2 ; i< n+1 ; i++){
            int left = dp[i-1];
            int right = dp[i-2];

            dp[i] = left+ right ;
        }

        return dp[n];
    }
}