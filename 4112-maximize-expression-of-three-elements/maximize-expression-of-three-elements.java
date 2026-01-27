class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int ans = nums[len -1] + nums[len-2] -nums[0];
        return ans ;
        
    }
}