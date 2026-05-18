class Solution {
    Integer dp[] ; 
    public int f(int ind , int nums[] , int d){
        
        if(dp[ind] != null ) return dp[ind];
        int prev = ind ; 
        int n = nums.length;
        int ans = 1 ; 
        for(int i = 1 ; i <= d ; i++){
            int front = ind + i ; 
            if(front >= n ){
                break ;
            }

            if(nums[front] >= nums[prev]){
                break;
            }
            ans = Math.max(ans , 1 + f(front , nums , d));
        }

        for(int i = 1 ; i <= d ; i++){
            int back = ind - i ;
            if(back < 0 || nums[back] >= nums[prev]){
                break;
            }
            ans = Math.max(ans , 1 + f(back , nums , d));
        }
        return dp[ind] = ans;
    }
    public int maxJumps(int[] arr, int d) {
        int ans = 0 ; 
        dp = new Integer[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            ans = Math.max(ans , f(i , arr , d));
        }

        return ans ;
    }
}