class Solution {
    public boolean f(int n , int target , int[] nums , int dp[][]){
        if(target == 0 ) return true; 
        if(n == 0 ) return (nums[n] == 0);
        if(dp[n][target] != -1) return dp[n][target] == 1 ;
        boolean notTake = f(n-1 , target , nums ,dp);
        boolean take = false;
        if(target >= nums[n]){
            take = f(n-1 , target -nums[n] , nums , dp);
        }

        if(take || notTake) dp[n][target] = 1;
        else dp[n][target] = 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0; 
        
        for(int n : nums){
            totalSum+= n;
        }

        if(totalSum % 2 != 0) return false ; 
        int target = totalSum/2;
        int dp[][] = new int[nums.length][target+1];
        for(int i =0 ; i < nums.length ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return f(nums.length-1 ,  target , nums ,dp);
    }
}