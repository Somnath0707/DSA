class Solution {
    Integer dp[][] ;
    int MOD = 1000000007;
    public int f(int sum , int dice , int n , int k , int target){
        if(dice == n ) 
        {
            if(sum == target) return 1 ; 
            else{
                return 0 ; 
            }
        }
        if(dp[sum][dice] != null) return dp[sum][dice];
        int ans = 0 ;
        
        for(int i =  1 ; i <= k ; i++){
            ans = ( ans + f(sum+i , dice+1 ,  n , k , target)) % MOD; 
        }
        return dp[sum][dice] = ans; 
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[1000+1][n+1];
        return f(0 , 0 ,n , k , target);
    }
}