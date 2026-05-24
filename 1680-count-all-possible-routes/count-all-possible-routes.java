class Solution {
    int dp[][] ; 
    int MOD = 1000000007;
    public int f(int i , int fuelRemain , int finish , int nums[]){
        // if(fuelRemain == 0 ) return 0; 
        int count = 0 ; 
        if(i == finish) count++;
        if(dp[i][fuelRemain] != -1) return dp[i][fuelRemain];

        for(int ind = 0 ; ind < nums.length ; ind++){
            if(ind == i ) continue;
            int cost = Math.abs(nums[ind] - nums[i]);
            if(cost <= fuelRemain)
            count = (count + f(ind , fuelRemain - cost  , finish , nums)) % MOD;
        }
        
        return dp[i][fuelRemain] = count ; 
    }
    public int countRoutes(int[] nums, int start, int finish, int fuel) {
        // we are given +ve int location array that tell us the pos of city i 


        // start finish and fuel showing the starting city endiing city and intal amount of fuel you have 

        // at each step we can pick city j such that j != i and move to city j 
        // moving reduce the amount of fuel by loc[i] - loc j abs

        // fuel cant be neg as we take the abs value
        // so we can vist any city more than once include start and end 

        // return count of all possible route start to end 
        int n = nums.length ; 
        dp = new int[n][fuel+1];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1 );
        }

        return f(start , fuel , finish , nums);
    }
}