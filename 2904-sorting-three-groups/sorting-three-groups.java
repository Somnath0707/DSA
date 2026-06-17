class Solution {
    int dp[][]; 
    public int f(int i , int prev , List<Integer> nums){
        if(i == nums.size()) return 0 ; 
        if(dp[i][prev] != 0 ) return dp[i][prev]; 
        int take = 0; 
        if(nums.get(i) >= prev || prev == 4){
            take = 1 + f(i+1 , nums.get(i) , nums );
        }
        int skip = f(i+1 , prev , nums);
        return dp[i][prev] = Math.max(take , skip) ; 
    }
    public int minimumOperations(List<Integer> nums) {
        // at each point when the number is greater than the next number we can remove that number 
        // we need to track prev what we took so that we could remove the next as per 
        int n = nums.size();
        int ans = 0 ; 

        dp = new int[n+1][5];
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans , f(0 , 4 , nums));
        }
        return n - ans;
    }
}