class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currSum = 0;
        int minSum = Integer.MAX_VALUE;

        int currMin = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            
            currSum = Math.max(nums[i] , currSum+nums[i]);
            maxSum = Math.max(currSum , maxSum);

            currMin = Math.min(nums[i] , currMin+ nums[i]);
            minSum = Math.min(minSum , currMin);

        }

        return Math.max(Math.abs(minSum) , maxSum);

        
    }
}