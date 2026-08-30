class Solution {
    Integer dp[][] ; 
    public int f(int i, int total, int nums[], int sum) {

        if(total == sum) return 0 ; 
        if (i == nums.length){
            return 1000000; 
        }

         if (total > sum)
            return 1000000;


        if(dp[i][total] != null) return dp[i][total]; 
        int take = 1000000;
        int skip = 1000000;
       
        take = f(i + 1, total + nums[i], nums, sum);
        int currSum = nums[i];
        int op = 0;

        while (currSum != 0) {
            currSum /= 2;
            op++;
            if (total + currSum <= sum)
                take = Math.min(take, op + f(i + 1, total + currSum, nums, sum));

        }
        currSum = nums[i];
        op = 0;
        while (currSum <= sum) {
            currSum *= 2;
            op++;
            if (currSum > sum)
                break;
            take = Math.min(take, op + f(i + 1, total + currSum, nums, sum));
        }

        skip = f(i + 1, total, nums, sum);


        return dp[i][total] =  Math.min(take , skip); 
    }

    public int minOperations(int[] nums, int sum) {
        int n = nums.length; 
        dp = new Integer[n][sum+1]; 
        int ans =  f(0, 0, nums, sum);

        if(ans >= 1000000) return -1; 
        return ans; 
    }
}