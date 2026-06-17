class Solution {
    int MOD = 1000000007;
    Integer dp[][]; 
    public int f(int sum, int ind ,  int n, int x) {
        if (sum == n) return 1;
        if (sum > n) return 0;
        

        int num = (int)Math.pow(ind , x);
        long take = 0 ; 
        long skip = 0 ; 

        if (sum + num > n && num > n)
            return 0;

        if(dp[sum][ind] != null ) return dp[sum][ind];

        if(sum + num <= n){
            take = f(sum+num , ind+1 , n , x);
        }

        skip =   f(sum , ind + 1 , n , x ) ; 

        return dp[sum][ind] = (int)((take + skip) % MOD); 

    }

    public int numberOfWays(int n, int x) {
        dp = new Integer[n+1][n+1];
       
        return f(0 , 1 , n, x);
    }
}