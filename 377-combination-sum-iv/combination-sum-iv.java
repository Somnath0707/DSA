class Solution {
    public int f(int i , int nums[] , int target , int dp[][] ) {
        if(i == nums.length ) return 0; 
        if(target == 0 ) return 1 ; 

        if(dp[i][target ] != -1 ) return dp[i][target] ; 

        int take = 0 ; 
        if(target - nums[i] >= 0 ){
            take = f(0 , nums , target - nums[i] , dp );
        }

        int skip = f(i+1 , nums , target , dp) ; 

        return dp[i][target] = take + skip ; 
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[][] = new int [nums.length][target+1];
        for(int i = 0; i < nums.length ; i ++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        return f(0 , nums , target  , dp) ; 
    }
}

// take a element or not take a element but when we not take we check from begining like 0 

// if [1,2,3] here we do not take 1 then if we take 2 we have to chekc with again from 0 i.e. take 0 or maybe not take 0  
// this mays this shi difficult 
// so we have optioon 1 : i + start from 0  2: skip 
//  1 + f(0 , target - nums[i] , nums ) ; 

// skip = f( i +1 , target , num s) ; 