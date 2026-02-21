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

        int dp[][] = new int [n][m];
        for(int i =0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return f(n-1 , m-1 , s , s2 ,dp);
        
    }
}