class Solution {
    Map<String , Integer > dp;
    public int f(int i  , int maxSum , int[] nums , int target){

        String key = i + "," + maxSum;
        if(i == nums.length ){
           int res = (maxSum == target) ? 0 : -10000;
           return res;
        }
        

        if(dp.containsKey(key)) return dp.get(key);

        

        int take = 1 + f(i+1 , maxSum ^ nums[i] , nums , target );

        int notTake = f(i + 1 , maxSum , nums , target);

        int ans = Math.max(take , notTake);
        dp.put(key , ans );

        return ans; 
    }
    public int minRemovals(int[] nums, int target) {
        dp = new HashMap<>();
        int ans = f(0 , 0 , nums , target);
        

        if(ans < 0) return -1 ; 

        int min= nums.length - ans;
        return min ;
    }
}