class Solution {
    int[]dp;
    public int f(int ind , int nums[]){
        if(ind >= nums.length-1) return 0 ; 
        if(dp[ind] != -1) return dp[ind];
        int take = Integer.MAX_VALUE - 1 ; 

        int currRange = nums[ind];
        for(int i = ind+1 ; i <= currRange + ind ; i++){
            take = Math.min(take , 1 + f(i , nums));
        }

        return dp[ind] = take;
    }
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return f(0  , nums);
    }
}