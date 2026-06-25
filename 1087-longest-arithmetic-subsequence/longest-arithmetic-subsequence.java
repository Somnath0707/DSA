class Solution {
    int dp[][] ; 
    public int f(int i ,  int diff , int[] nums){
        if(i == nums.length ) return 0 ; 

        // if(prev != -1 && nums[i]- prev == diff ){
        //     return 1 ; 
        // }

        if(dp[i][diff] != -1 ) return dp[i][diff]; 

        int ans = 0 ; 
        for(int j = i+1 ; j < nums.length ; j ++ ){
            int newDiff = nums[j]- nums[i] + 500;
            if(diff != 1000 && newDiff == diff ){
                ans = Math.max( ans , 1 + f(j , newDiff , nums));
                break; 
            }
            else if(diff == 1000 ){
                ans = Math.max(ans , 1 + f(j, newDiff , nums));
            }
        }

        return dp[i][diff] = ans; 
    }
    public int longestArithSeqLength(int[] nums) {
        // just find the longest sub sequence whoes diff is same 
        int ans = 0 ; 
        int n = nums.length; 
        dp = new int[n][1002]; 
        for(int i =0 ; i < n ; i++){
            Arrays.fill(dp[i] , - 1) ; 
        }
       
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans , 1 + f(i ,1000, nums));
        }

        return ans; 
    }
}