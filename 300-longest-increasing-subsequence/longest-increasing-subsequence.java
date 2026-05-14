class Solution {

    Integer dp[][] ; 
    public int f(int i , int j , int [] nums){
        if(i >= nums.length) return 0 ; 
        if(j >= nums.length ) return 0 ; 
        if(dp[i][j] != null) return dp[i][j];

        int take = 0 ; 
        if(nums[j] > nums[i]){
            take = 1 + f(j , j+1 , nums);
        }

        int skip = f(i , j+1 , nums);

        return dp[i][j] =  Math.max(skip , take);
    }
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        dp = new Integer[nums.length][nums.length];
        for(int i = 0 ; i < nums.length; i++){
            ans = Math.max(ans , 1 + f(i , i , nums));
        }

        return ans; 
    }
}