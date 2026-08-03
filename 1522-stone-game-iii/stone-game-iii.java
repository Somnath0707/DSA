class Solution {
    Integer dp[]; 
    public int f(int i , int nums[]){
        int n = nums.length; 
        if(i == nums.length) return 0 ; 
        int take = Integer.MIN_VALUE;
        if(dp[i] != null) return dp[i]; 
        if(i <= n-3){
            int take1 = nums[i] - f(i+1 , nums); 
            int take2 = nums[i] + nums[i+1] - f(i+2 , nums);
            int take3 = nums[i] + nums[i+1] + nums[i+2] - f(i+3 , nums);
            
            take = Math.max(take ,Math.max(take1 , Math.max(take2 , take3)));
            // System.out.println(take);
        }   
        if(i <= n-2){
            int take1 = nums[i] - f(i+1 , nums); 
            int take2 = nums[i] + nums[i+1] - f(i+2 , nums);
            take = Math.max(take , Math.max(take1 , take2));
        }
        else{
            take = Math.max(take , nums[i] - f(i+1 , nums)); 
        }
        return dp[i] = take; 
    }
    public String stoneGameIII(int[] nums) {
        // FIRST THOUGHT IS USING DP BUT THE STATS ARE i sum1 sum2 turn alice always try to win and bob try to make him loose so return 0 if alic 1 false if bob wins and if tie then 2 
        // but this many states i sum 1 sum2 lest see 10000 , 2000 2000 2 so totla is 10^11 ish this does not work 

        // if alice wins its a def win for alice cause he is starting first but if bob wins its does not mean he def win cause there may be one route where he loses so for alice its || and for bob its && 

        // we just take for the alice if he tries all optimally and skip 1 2 3 for bob and still gets the more than /2 fo the total then its the win for alice if less than half its lose if same its tie

        // but how does we know that how much will bob take we can try all of them like skip 1 skip 2 skip 3 but how will we know which final answer to take the one with the minimum cause bob is trying to reduce or score but min score [1,2 , 3 , ] here alice can take 1, 1 2 , 1 2 3 the min will come from 1 that is not true alcie should also try to maximize its answer 

        // after skipping it tries to maximize its answer but how do i know which answer to take and which is maximum like suppose we have 1 2 3 how does alice take all 3 how does he get to know about that its just 3 steps ahead ig its ok to see all three which every gives max we take that 

        // so our thought is try to make alice min but at each point where he is in charge he should maximize his answer so for 3 steps he should take one which has the maximum answer but but but but if current taking 2 steps further leads to the later alice getting bigger lead so we canot take greedily the best step here we need to try each option at the end at any point if the 
        // bob take = Math.max(1 , 3 4 ) - f
        int n = nums.length; 
        dp = new Integer[n]; 
        int ans =  f(0 , nums);
        if(ans < 0) return "Bob";
        else if(ans == 0) return "Tie";

        return "Alice";
    }
}