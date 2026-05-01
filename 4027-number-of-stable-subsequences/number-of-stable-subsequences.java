class Solution {
    Integer dp[][][];
    int MOD = 1000_000_007;
    public int f(int i , int currParity , int count , int[] nums){
        if(i == nums.length ) return 1 ; 

        if(dp[i][currParity][count] != null) return dp[i][currParity][count];

        int notTake = f(i+1 , currParity , count , nums);

        int newParity = nums[i] % 2; 
        int take = 0 ; 

        if(currParity == 2){
            take = f(i+1 , newParity , 1 , nums);
        }else if(currParity == newParity){
            if(count < 2 ){
                take = f(i+1 , newParity , count + 1 , nums);
            }
        }
        else{
            take = f(i+1 , newParity , 1 , nums);
        }

        return dp[i][currParity][count] = (take + notTake ) % MOD; 
    }
    public int countStableSubsequences(int[] nums) {
        dp = new Integer[nums.length + 1 ][4][4];
        return f(0 , 2 , 0 , nums) - 1 ;
    }
}