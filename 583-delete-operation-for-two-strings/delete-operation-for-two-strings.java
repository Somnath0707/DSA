class Solution {
    public int f(int n , int m , String s , String s2 , int dp[][]){
        if(n < 0 || m < 0) return 0; 

        if(s.charAt(n) == s2.charAt(m)) return 1 + f(n-1 , m-1 , s , s2 , dp);
        if(dp[n][m] != -1) return dp[n][m];
        return dp[n][m] = 0 +  Math.max(f(n-1 , m , s , s2 , dp) ,f(n , m-1 , s , s2 , dp));
        
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m][n];
        for(int i =0 ; i< m ; i++){
            Arrays.fill(dp[i] , -1 );
        }
        int ans = f(m-1 , n-1 , word1 , word2 ,dp);

        return m + n - (2 * ans);
    }
}