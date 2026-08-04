class Solution {
    Integer[][] dp ; 
    public int f(int i , int j , int[]nums){
        if(i > j) return 0 ; 
        if(dp[i][j] != null ) return dp[i][j]; 
        int take = Integer.MIN_VALUE; 


        int take1 = nums[j] - nums[i] - f(i+1 , j , nums);
        int take2 = nums[j-1] - nums[i-1] - f(i , j-1 , nums); 

        take = Math.max(take , Math.max(take1 , take2));

        return dp[i][j] = take; 
    }
    public int stoneGameVII(int[] stones) {
        // take prefix sum 
        // alice do Max(left ,right)-bob(max(leftright)) at end reutnr the diff 
        
        int n = stones.length ; 
        dp = new Integer[n+2][n+2]; 
        int nums[] = new int[n+1]; 

        nums[0] = stones[0]; 
// production
        for(int i = 1 ; i < n+1 ; i++){
            nums[i] = stones[i-1] + nums[i-1]; 
        }
        // 0 5 8 9 13 15
        int m = nums.length-1; 

        return f(1 , m  ,nums);

    }
}