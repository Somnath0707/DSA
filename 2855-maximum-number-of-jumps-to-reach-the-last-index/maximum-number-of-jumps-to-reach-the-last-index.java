class Solution {
    Integer dp[][] ; 
    public int f(int i , int j , int[] nums , int k ){
        int n = nums.length ; 
        if(i == n-1) return 0 ; 
        if(j >= n) return -10000000;
        
        
        
        if(dp[i][j] != null ) return dp[i][j]; 

        int take = -10000000 ; 
        int skip = -1 ;

        if(i < j && nums[j] - nums[i] <= k && nums[j] - nums[i] >= -k){
            take = 1 + f(j , j+1 , nums , k );
        }

        skip = f(i , j+1 , nums , k );

        return dp[i][j] =  Math.max(take , skip);
        


    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length ;
        dp = new Integer[n][n];
        int ans = f(0 , 1 , nums , target);
        if(ans < 0 ) return -1 ; 
        return ans; 
    }
}