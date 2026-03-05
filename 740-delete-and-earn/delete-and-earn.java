class Solution {
    public int f(int i , int [] nums , int dp[]){
        if(i >= nums.length ) return 0 ; 

        if(dp[i] != -1 ) return dp[i];

        int currVal = nums[i];
        int totalAns = nums[i];
        int indx = i + 1;

        while(indx < nums.length && nums[indx] == currVal){
            totalAns += nums[indx];
            indx++;
        }

        while(indx < nums.length && nums[indx] == currVal + 1 ){
            indx++;
        }

        return dp[i] =  Math.max(totalAns + f(indx , nums , dp  ) , f(i+1 , nums , dp ));
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1 ) ;

        return f(0 , nums , dp );
    }
}