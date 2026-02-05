class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int ans [] = new int[nums.length];
        int n = nums.length;

        // take a loop move forward till the i once we reach the i change the nums[i] with the number we are at that time 
        // If we get a negative value move to back i.e. to the left of the array 7

        
        for(int i = 0 ; i < n ; i++){
            if( nums[i] > 0){
                int nextIndx = (i + nums[i] ) % n;
                ans[i] = nums[nextIndx];
            }
            else if (nums[i] < 0){
                int prevIndex = ((i - Math.abs(nums[i])) % n + n) % n;
                ans [i] = nums[prevIndex];
            }
            else if (nums[i] == 0 ){
                ans[i] = nums[i];
            }
        }
        return ans ; 
    }
}