class Solution {
    int MOD = 1000000007; 
    Integer dp[][]; 
    public int f(int i , int taken , int n ){
        if( i == n ){
            return 1; 
        }

        if(dp[i][taken] != null ) return dp[i][taken]; 

        long take = 0 ; 

        if(taken == 0){
            take = (take + f(i+1 , 1 , n)) % MOD;
            take = (take + f(i+1 , taken , n)) % MOD;
        }
        else {
            take = (take + f(i+1 , 0 , n )) % MOD;
        }

        return dp[i][taken] = (int)take % MOD; 
    }
    public int countHousePlacements(int n) {
        dp = new Integer[n][2]; 
        int oneSide = f(0 , 0 , n );
        // int allEmpty = 1; 
        // int oppPos = n
        
        long ans = (1L * oneSide * oneSide) % MOD;
        return (int)ans; 
    }
}