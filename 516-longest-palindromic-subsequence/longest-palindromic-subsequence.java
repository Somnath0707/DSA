class Solution {
    public int f(int n , int m , String s , String s2 ,int [][]dp){
        if(n < 0 || m < 0 ){
            return 0;
        }
        if(dp[n][m] != -1 ) return dp[n][m] ;
        if(s.charAt(n) == s2.charAt(m) ) return 1 + f(n-1 , m - 1 , s , s2 ,dp);

        return dp[n][m] =  0 + Math.max(f(n-1 , m, s , s2 ,dp) , f(n , m - 1 , s , s2 ,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();


        int n = s.length();
        int m = s2.length();

        int dp[][] = new int [n+1][m+1];

        for(int i = 0 ; i<= n ; i++){
            dp[i][0] = 0;
        }

        for(int j = 0 ; j <= m ; j++ ) dp[0][j] = 0 ; 
        
        for(int i = 1; i <= n ; i++){
            for(int j =1 ; j<= m ;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];

                else {
                    dp[i][j] =  0 + Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
        
    }
}