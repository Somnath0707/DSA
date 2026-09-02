class Solution {
    int MOD = 1000000007; 
    Integer dp[][][][]; 
    public int f(int i , int takeZero , int takeOne , int  takeTwo , int[] nums){
        if(i == nums.length ){
            if(takeZero == 1 && takeOne == 1 && takeTwo == 1) return 1; 
            return 0 ; 
        } 
        if(dp[i][takeZero][takeOne][takeTwo] != null ) return dp[i][takeZero][takeOne][takeTwo];
        int take = 0 ; 
        int skip = 0 ; 
       
        if(nums[i] == 0 && takeOne == 0 && takeTwo ==0 ){
            take = f(i+1 , 1 , 0 , 0, nums);
        }
        else if(nums[i] == 1 && takeZero == 1 && takeTwo == 0 ){
            take = f(i+1 , 1 , 1 , 0, nums);
        }
        else if(nums[i] == 2 && takeZero == 1 && takeOne == 1){
            take = f(i+1 , 1 , 1 , 1 , nums);
        }

        skip = f(i+1 , takeZero , takeOne , takeTwo , nums);

        int ans = (take + skip) % MOD; 
        dp[i][takeZero][takeOne][takeTwo] = ans; 
        return ans; 
    }
    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length; 
        dp = new Integer[n][2][2][2]; 
        return f(0 , 0 , 0 , 0 , nums);
    }
}