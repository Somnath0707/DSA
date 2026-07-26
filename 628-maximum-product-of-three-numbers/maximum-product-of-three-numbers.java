class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums); 
        int n = nums.length;
        int ans = 0 ; 
        if(nums[0] * nums[1] * nums[n-1] > nums[n-1] * nums[n-2] * nums[n-3]){
            ans = nums[0] * nums[1] * nums[n-1]; 
        }
        else{
            ans = nums[n-1] * nums[n-2] * nums[n-3];
        }

        return ans; 
    }
}