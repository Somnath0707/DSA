class Solution {
    public int maxProfit(int[] nums) {

        int i =0 ; 
        int j =0 ;
        int ans = 0; 
        while(i < nums.length && j < nums.length){
            if(nums[i]<= nums[j]){
                ans= Math.max(ans , nums[j] - nums[i]);
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}