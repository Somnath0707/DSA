class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;

        // store the max answe till that time 
        int ans = 0 ;

        // if the length is 1 we can rob only that house 
        if(n == 1) return nums[0];

        // at 0 we can only rob that house 
       int prev2 = nums[0];

        // now next we could either rob 0 th house or the 1 th house and store the max in the 1 th in the array h
        int prev = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < n ; i++){
           ans = Math.max(nums[i] + prev2,prev);
           prev2 = prev;
           prev = ans;
        }

        return prev;
        
    }
}