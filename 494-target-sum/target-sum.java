class Solution {
    public int f(int n ,  int target , int[]nums , int dp[][] , int offset){
        if (target > offset || target < -offset) {
        return 0;
        }
        if(n == 0 ) {
            int count = 0;
            if(nums[0] == target )count ++;
            if(-nums[0] == target) count ++;
            return count; 
        }
        
        if(dp[n][target + offset] != -1) return dp[n][target + offset];

        int sub = f(n-1, target - nums[n] , nums ,dp , offset);
        int add = f(n-1 , target + nums[n] , nums ,dp ,offset);

        return dp[n][target + offset] = sub + add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length ;

        int sum =0 ;

        for(int num : nums) sum+= num;
        int offset = sum;

        if (Math.abs(target) > sum) return 0;

        int dp[][] = new int [n][2 * sum + 1];

        for(int i =0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        
        return f(n-1 , target, nums ,dp ,offset);
    }
}