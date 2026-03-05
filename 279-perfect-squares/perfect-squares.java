class Solution {
    public int f(int i , int n , int []nums , int dp[][]){
        if( n == 0  ) return 0 ; 
        if( i == nums.length) return (int)1e9;
        if(dp[i][n] != 0  ) return dp[i][n] ; 
        int pick = Integer.MAX_VALUE ; 
        if(n - nums[i] >= 0 ) {
            pick = 1 + f(i , n-nums[i], nums , dp );
        }

        int notPick = f(i+1 , n , nums , dp );

        return dp[i][n] = Math.min(pick , notPick);
    }
    public int numSquares(int n) {

        int maxRoot = (int) Math.sqrt(n);
        int nums[] = new int[maxRoot];
        
        for(int i = 0; i < maxRoot ; i++){
            nums[i] = (i + 1) * (i + 1 ) ; 
        }

        int dp [][] = new int[maxRoot][n+1] ; 
        

        return f(0 , n , nums , dp);
    }
}