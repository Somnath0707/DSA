class Solution {
    public int minimumDifference(int[] nums, int k) {

        //If k is one it will always be the own element so own element - element = 0
        if(k == 1 ) return  0;

        //window start
        int i = 0 ; 
        // End of the window 
        int j = k-1;

        // sort the nos to get the min and max from that window 
        Arrays.sort(nums);

        // ans 
        int ans = Integer.MAX_VALUE;

        while(j<nums.length){
            ans = Math.min(ans , nums[j++]  - nums[i++]);
        }
        return ans ;
    }
}