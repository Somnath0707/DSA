class Solution {
    int n ; 
    int MOD = 1000000007;
    Integer dp[][];
    public int f(int i , int fuelRemain , int finish , int nums[]){

        int count = 0 ;
        if(i == finish) count++;
        if(dp[i][fuelRemain] != null ) return dp[i][fuelRemain] ;


        for(int ind = 0 ;  ind < n ; ind++){
            if(i == ind) continue;// same city skip 

            int cost = Math.abs(nums[i] - nums[ind]);
            // if the fuel every goes below the cost this will not get executed so no need to do the bs of the base case for it 
            if(cost <= fuelRemain){
                count =  (count + f(ind , fuelRemain-cost , finish , nums)) % MOD;
            }
        }

        return dp[i][fuelRemain] = count ; 
    }
    public int countRoutes(int[] nums, int start, int finish, int fuel) {
        this.n = nums.length; 
        dp = new Integer[n][fuel+1];
        return f(start , fuel , finish , nums);
    }
}