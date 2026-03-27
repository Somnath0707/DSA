class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0 ; 
        int right = 0 ; 
        int mul = 1 ; 
        int ans = 0; 
        int n = nums.length ; 

        while( right < n) {
            mul *= nums[right];

            while( mul >= k ){
                mul /= nums[left];
                left ++ ; 
            }

            ans += right - left + 1 ; 
            right ++;
        }

        return ans; 
    }
}