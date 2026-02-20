class Solution {
    public int f(int n ,  int target , int[]nums){
        if(n == 0 ) {
            int count = 0;
            if(nums[0] == target )count ++;
            if(-nums[0] == target) count ++;
            return count; 
        }

        int sub = f(n-1, target - nums[n] , nums);
        int add = f(n-1 , target + nums[n] , nums);

        return sub + add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        int n =nums.length ;
        int total = 0 ; 
        return f(n-1 , target, nums);
    }
}