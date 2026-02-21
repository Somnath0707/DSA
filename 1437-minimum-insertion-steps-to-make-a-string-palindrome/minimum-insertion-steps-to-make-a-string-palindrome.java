class Solution {

    public int f(int n , int m , String s , String s1 , int dp[][]){
        if(n <0 || m <0 ) return 0 ; 

        if(dp[n][m] != -1 ) return dp[n][m];
        if(s.charAt(n) == s1.charAt(m)) return 1 + f(n-1 , m-1 , s , s1 ,dp);

        return dp[n][m] = Math.max(f(n-1, m , s , s1 ,dp) , f(n , m-1 , s , s1 , dp));
    }
    public int minInsertions(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int n =  s1.length();

        int dp[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int ans = n - f(n-1 , n-1 , s, s1 ,dp);

        return ans ; 
    }
}