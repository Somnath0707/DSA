class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = -1 ;
        int n = nums.length; 
        long min = Integer.MAX_VALUE; 
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , nums[i]);
            min = Math.min(nums[i] , min );
        }
        long ans = (max - min) * k * 1L;
        return ans;
    }
}