class Solution {
    public int robCount(int[] nums) {
        int n = nums.length ;
        int dp[] = new int[n];
        if(n == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }

        return dp[n-1];
        
    }
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0];
        int temp1[] = new int[nums.length];
        int temp2[] = new int[nums.length-1];

        for(int i =0; i < nums.length ; i++){
            if(i != 0){
                temp1[i] = nums[i];
            }
            if(i != nums.length-1){
                temp2[i] = nums[i];
            }
        }

        return Math.max(robCount(temp1) , robCount(temp2));
    }
}