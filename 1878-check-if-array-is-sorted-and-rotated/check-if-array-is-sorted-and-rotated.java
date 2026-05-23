class Solution {
    public boolean check(int[] nums) {
        int dip = -1; 
        int n = nums.length;
        int count = 0 ; 
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[i-1] && count ==1 )return false;
            if(nums[i] < nums[i-1]) count++;
        }

        if(count == 0 ) return true; 

        if(nums[0] < nums[n-1] )return false;

        return true ;
    }
}