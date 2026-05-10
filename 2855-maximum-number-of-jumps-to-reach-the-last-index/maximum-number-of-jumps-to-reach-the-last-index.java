class Solution {
    Map<String , Integer> dp ; 
    public int f(int i , int j , int nums[] , int k ) {
        int n = nums.length; 
        String key = i + "#" + j ; 
        if(i == n-1) return 0 ; 
        if( j >= n ) return -100000000;
        if(dp.containsKey(key)) return dp.get(key);
        int take = -100000000;
        int skip = -1 ; 

        if(i < j && nums[j] - nums[i] <= k && nums[j] - nums[i] >= -k ){
            take = 1 + f(j , j+1 , nums , k);
        }

        skip = f(i , j+1 , nums , k );

        int ans = Math.max(skip , take );
        dp.put(key , ans);
        return ans;
    }
    public int maximumJumps(int[] nums, int target) {
        dp = new HashMap<>();
        int ans = f(0 , 0 , nums , target);
        if(ans < 0 ) return -1; 

        return ans ; 
    }
}