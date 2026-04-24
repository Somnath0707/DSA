class Solution {
    Boolean dp[]; 
    public boolean f(int n ){
        if(n == 0 ) return false ; 
        if(dp[n] != null) return dp[n];
        for(int i = 1 ; i*i <= n ; i++){
            if(!f(n- i*i)){
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
    public boolean winnerSquareGame(int n) {
        // pick the squares until the i^2 < n 
        // check that if there is any chance of the bob winning 
        dp = new Boolean[n+1];
        return f(n);
    }
}