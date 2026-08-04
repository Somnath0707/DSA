class Solution {
    Integer dp[][]; 
    public int f(int i , int j , int [] nums){
        if(i == j) return 0 ; 
        if(dp[i][j] != null) return dp[i][j]; 
        int take = 0 ; 
        int n = nums.length;//     i   k        j
        // 6,2,3,4,5,5 ->        0 6 8 11 15 20 25 
        for(int ind = i ; ind < n ; ind++){
            // if(ind + i > j ) break; 
            int sum1 = nums[ind]  - nums[i-1]; // left 
            int sum2 = nums[j] - nums[ind]; // right

            if(sum1 > sum2){
                take = Math.max(take , sum2 + f(ind+1 , j , nums)); 
            }
            else if(sum2 > sum1) {
                take = Math.max(take , sum1 + f(i , ind  , nums));
            }
            else{
                take = Math.max(take , Math.max(Math.max(take , sum2 + f(ind+1 , j , nums)) , Math.max(take , sum1 + f(i , ind  , nums))));
            }
        }

        return dp[i][j] =  take; 
    }
    public int stoneGameV(int[] stoneValue) {
        // is it just a partation dp problem ? 

        // like at each point partion and check and take the max 

        // like for loop then max(sum + (i , j , rightSum + f(right side ) )
        int n = stoneValue.length; 
        dp = new Integer[n+2][n+2]; 
        int nums[] = new int[n+1]; 

        nums[0] = 0 ; 
        for(int i = 1 ; i<=n; i++){
            nums[i] = stoneValue[i-1] + nums[i-1]; 
        }

        int temp =f(1 , n , nums);
        return temp ;
    }
}