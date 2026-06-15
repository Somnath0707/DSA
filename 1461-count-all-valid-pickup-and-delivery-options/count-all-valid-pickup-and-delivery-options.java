class Solution {
    int dp[][]; 
    int MOD = 1000000007;
    public int f(int picked , int delivery , int n ){
        if(picked == n && delivery == 0 ) return 1;
        if(dp[picked][delivery] != -1 ) return dp[picked][delivery]; 

        int pickWays = 0 ;
        int deliveryMethod = 0 ;  
        if(picked < n )
            pickWays = (int)(((long)(n - picked) * f(picked + 1 , delivery+1 , n)) % MOD);

        if(delivery >=1 ) {
            deliveryMethod = (int)(((long)delivery * f(picked , delivery-1 , n )) % MOD);
        }

        return dp[picked][delivery] = (pickWays + deliveryMethod) % MOD;

    }
    public int countOrders(int n) {
        // given n orders each order consist of a pickup and delivey service 

        // count all valid pickup possible subsequencey such that devlivey is alowesy after a pickup i 

        // at each point if we have picked we can either deliveer or pick another right at the end we pick all and deliver the remaining 
        dp = new int[n+1][n+1]; 
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        return f(0 , 0 , n );
    }
}