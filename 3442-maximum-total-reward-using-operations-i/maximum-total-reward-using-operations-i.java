class Solution {
    int dp[][] ; 
    public int f(int i , int sum , int []nums){
        if(i == nums.length ) return 0 ;

        if(dp[i][sum] != -1 ) return dp[i] [sum];

        int take = 0 ;
        if(nums[i] > sum ){
            take = nums[i] + f(i+1 , sum + nums[i] ,  nums);
        }
        int skip = f(i+1 ,sum ,  nums);


        int ans = Math.max(take , skip );
        return dp[i][sum] = ans ; 
    }
    public int maxTotalReward(int[] rewardValues) {
        
        Arrays.sort(rewardValues);
        dp = new int[rewardValues.length][20100];
        for(int i = 0 ; i < rewardValues.length ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return f(0 , 0,   rewardValues);
    }
}

// [1,6,4,3,2] -> 1,2,3,4,6