class Solution {
    public long minOperations(int[] nums) {
        long prev = 0 ;
        int n = nums.length; 
        long cost = 0 ; 
        long currentMax = nums[0];

        for(int i = 1 ; i < n; i++){
            currentMax = Math.max(currentMax , nums[i]);

            long currA = currentMax - nums[i];

            cost += Math.max(0L , currA- prev);

            prev = currA;
        }

        return cost;
    }
}