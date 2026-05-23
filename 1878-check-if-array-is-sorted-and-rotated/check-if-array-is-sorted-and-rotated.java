class Solution {
    public boolean check(int[] nums) {
        int dip = -1; 
        int n = nums.length;
        int count = 0 ; 
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[i-1] && count ==1 )return false;
            if(nums[i] < nums[i-1]) count++;
        }
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[i-1]){
                dip = i ;
                break;
            }
        }
        if(dip == -1 ) return true; 
        int left = dip-1;
        int right = dip+1;

        // while(left >= 0 && right < n){
        //     if(nums[left]<nums[right] ) return false;
            
        //     left--;
        //     right++;
        // }
        if(nums[0] < nums[n-1] )return false;

        return true ;
    }
}