class Solution {
    Long dp[]; 

    public long f(int i , int nums[] , int k){
        if(i == nums.length) return 0; 

        if(dp[i] != null) return dp[i]; 

        long take = Integer.MAX_VALUE ; 
        Map<Integer,Integer> map = new HashMap<>(); 
        int total = 0 ; 
        for(int ind = i ; ind < nums.length ; ind++){
            int val = nums[ind]; 
            if(map.containsKey(val) && map.get(val) >1 ){
                total -= map.get(val);
            }
            map.put(nums[ind] , map.getOrDefault(nums[ind] , 0) + 1 ); 
            if(map.get(val) > 1)
            total += map.get(val); 

            take = Math.min(take , 1L * total + k + f(ind+1 , nums , k));
        }

        return dp[i] = take; 


    }
    public int minCost(int[] nums, int k) {
        // at each point we want total dups and just that in that range 
        int n = nums.length; 
        dp = new Long[n+1]; 
        return (int)f(0  , nums , k);
    }
}