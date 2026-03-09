class Solution {
    public int f(int n , int dp[]){
        if (n== 1 || n == 2 ) return 1;
        if(dp[n] != 0 ) return dp[n];
        int res = Integer.MIN_VALUE;
        for(int i =1 ; i < n ; i++){
            int product = i * Math.max(f(n-i , dp ) , n-i);
            res = Math.max(res , product);
        }
        return dp[n] =  res;
    }
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        
        return f(n, dp);
    }
}