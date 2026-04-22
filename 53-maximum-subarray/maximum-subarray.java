class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE ; 
        int sum = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            if(sum < 0 ){
                sum = curr;
            }

            else{
                sum += curr;
            }
            max =  Math.max(sum , max);
        }
        return max;
    }
}