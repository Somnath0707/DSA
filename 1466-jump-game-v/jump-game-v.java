class Solution {
    Integer dp[]; 
    public int f(int i  , int nums[] , int d){
        // base case
        // if we cant go form curr to +d and from curr to -d then we need to stop 
        if(dp[i] != null) return dp[i];
        int n = nums.length;
        int prev = i ; 
        int ans = 0 ;
        for(int ind = 1 ; ind <= d ; ind++ ){
            int front = ind + i ;

            if(front >= n ) break;
            if(nums[front] >= nums[prev]){
                break;
            }
            ans = Math.max(ans , 1 + f(front , nums , d));
        }

        for(int ind = 1 ; ind <= d ; ind++){
            int back = i - ind;
            if(back < 0){
                break;
            }
            if(nums[back] >= nums[prev]){
                break;
            }
            

            ans = Math.max( ans , 1 + f(back , nums , d));
        }

        return dp[i] = ans;
  
    }
    public int maxJumps(int[] arr, int d) {
        int ans = 0 ;
        dp = new Integer[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            ans = Math.max(ans , f(i  , arr , d));
        }
        return 1+ans;
    }
}