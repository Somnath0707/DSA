class Solution {
    public int f(int i , int prev ,  int nums[] , int k , int dp[][][] ) {
        if(i >= nums.length ) return 0 ; 

        if(dp[i][prev+1][k] != -1 ) return dp[i][prev+1][k] ; 
        
        int skip = f( i +1 , prev , nums, k , dp ) ;

        int take = 0;


        // if the first element so prev would be -1 
        if(prev == -1  )
        take = 1 + f(i + 1, i , nums , k , dp ); 


        else if (nums[i] == nums[prev]){
            take = 1 + f(i + 1, i , nums , k  , dp ) ; 
        }

        else if ( k > 0 ) {
            take = 1 + f(i + 1 , i , nums , k -1 , dp ) ; 
        }

        return dp[i][prev+1][k] = Math.max(take , skip ) ; 
        
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length ; 
        int dp[][][] = new int[n][n+1][k+1];
        for(int i = 0; i < nums.length ; i++){
           for(int j = 0 ; j < nums.length +1 ; j++){
            Arrays.fill(dp[i][j] , -1 ) ; 
           }
        }
        return f(0 , -1 ,  nums , k , dp  ) ; 
    }
}