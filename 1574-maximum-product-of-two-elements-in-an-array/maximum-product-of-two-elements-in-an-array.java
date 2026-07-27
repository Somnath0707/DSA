class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length; 
        int first = nums[n-1]-1; 
        int second = nums[n-2]-1; 

        return first * second ; 
    }
}