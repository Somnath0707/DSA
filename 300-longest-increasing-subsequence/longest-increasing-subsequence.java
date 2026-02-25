class Solution {
    
    public int f(int i , int prev , int [] nums , int dp[][]){
        if(i == nums.length ) return 0 ; 

        if(dp[i][prev + 1] != -1 ) return dp[i][prev + 1];
        int len = f(i+1, prev , nums ,dp);

        if(prev == -1 ||nums[i] > nums[prev]){
            len= Math.max(len ,  1 + f(i+ 1, i , nums ,dp) );
        }
        return dp[i][prev + 1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int [n][n+1];
        for(int i =0 ; i< n ; i ++){
            Arrays.fill(dp[i] , - 1) ; 
        }
        return f(0 , -1 , nums ,dp);
    }
}