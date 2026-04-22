class Solution {
    public int maxProfit(int[] nums) {
        int i = 0 ; 
        int j = 0 ; 
        int ans = 0 ; 
        int n = nums.length;
        while(i< n && j < n ){
            if(nums[i] <= nums[j]){
                int diff = nums[j] - nums[i];
                ans = Math.max(ans , diff);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}