class Solution {
    int n ; 
    long dp[][]; 
    public long f(int i , int sign , int[]nums){
        if(i == n ) return 0 ; 

        long ans = Integer.MIN_VALUE ; 
        if(dp[i][sign] != -1 ) return dp[i][sign]; 

        if(sign == 0 )
        // if current sign is + no matter its no or old it will alwasy have to + the nubmer 
        ans = Math.max(ans , nums[i] + f(i+1 , 1 , nums) );

        if(sign == 1 ){
            //                              sub the value               start new subarray
            ans = Math.max(ans , Math.max(-nums[i] + f(i+1 , 0 , nums) , nums[i] + f(i+1 , 1 , nums)));
        }

        return dp[i][sign] =  ans; 
    }
    public long maximumTotalCost(int[] nums) {
     // we have int array or nums and len n 

    //  the cost of sub arr is len l to r wher l <= r < n 

    // so we make try with the sub array so we will need state 
    // first state is ofc the i 

    // one is to tell if the current is + or - 
    // one state for telling use that is the end of the sub array so next should be restarted 

    // so state would look like i , sign , start 
    // so the total would be i * sign * start  = 10^5 * 2 * 2 = 4 * 10 ^ 5 which is pretty in the limit I'd say right 

    // base case is that if we reach the last index we get the answer 
    
    // ans = Math.max(end curren sub array here , end the dont end the curren sub array )
    // or 
    // ans = Math.max(ans , nums[i] +/- f(i+1 , +/- , start))

    // we would also need to tell to tell that we stop the sub array 
    // so like after current is taken or curr is the start of the new sub array 
    // so may be 3 states are unncesaay maybe two can suffice but idk 
    // ok two is compulary for sure but the last one 
    // or at each ponit we can do is contineu the current sub array or start new sub array and take the max of each of them 

    // yeah maybe that is the right direction 
    
    n = nums.length ;
    dp = new long[n+1][2];
    for(int i = 0 ; i < n ; i++){
        Arrays.fill(dp[i] , -1 ) ; 
    }
    return f(0 , 0 , nums );


    }
}