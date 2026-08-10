class Solution {
    Boolean dp[][]; 

    public boolean  f(int n , int turn ){
        if(n == 0){
            if(turn == 1) return true; 
            return false; 
        }
        if(dp[n][turn]!= null) return dp[n][turn]; 
        boolean alice = false; 
        if(turn == 0){
        for(int i = 1 ; i *i <= n ; i++){
            if(n-i*i >= 0){
                alice = alice || f(n-i*i , 1); 
            }
        }}

        if(turn == 1){
            alice = true;
            for(int i = 1 ; i *i <= n ; i++){
                
                if(n-i*i >= 0){
                    alice = alice && f(n-i*i , 0); 
                }
            }  
        }
        return dp[n][turn] =  alice ; 
    }
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n+1][3]; 
        return f(n , 0 ); 
    }
}