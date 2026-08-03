class Solution {
    Integer dp[][]; 
    public int f(int i , int m , int nums[]){
        int n = nums.length-1; 
        if(i > n) return 0; 
        if(dp[i][m] != null) return dp[i][m]; 
        int take = Integer.MIN_VALUE ; 

        for(int ind = 1 ; ind <= 2 * m ; ind++){
            if(i+ind-1 > n ) break; 
            int newM = Math.max(m , ind); 
            take = Math.max(take , nums[i+ind-1] - nums[i-1] - f(i+ind , newM , nums));
        }

        return dp[i][m] = take; 
    }
    public int stoneGameII(int[] piles) {
       
        int n = piles.length; 
        int nums[] = new int[n+1];
        nums[0] = 0 ; 
        for(int i = 1; i <= n ; i++){
            nums[i] = piles[i-1] + nums[i-1];
        } 
        dp= new Integer[n+2][n+2];
        int diff = f(1 , 1 , nums);
        return (nums[n]+diff)/2;
    }
}