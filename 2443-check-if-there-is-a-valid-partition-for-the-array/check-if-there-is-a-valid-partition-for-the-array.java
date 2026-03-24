class Solution {
    Boolean dp[];
    public boolean f(int i ,int nums[] ){
        int n = nums.length ;
        if(i == nums.length ) return true;

        boolean ans = false ;
        if(dp[i] != null) return dp[i];



        if(i+1 < n && nums[i] == nums[i+1]){
            ans |= f(i+2, nums);
        }

        if(i + 2 < n && nums[i] == nums[i+1]  && nums[i+1] == nums[i+2]){
            ans |= f(i+3 , nums) ;
        }

        if(i+2 < n && nums[i] == nums[i+1]-1 && nums[i+1]-1  == nums[i+2]-2){
           ans |=  f(i+3 ,nums);
        }

        return dp[i] = ans ;
    }
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length];
       return  f(0 , nums);
    }
}