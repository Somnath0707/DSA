class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int count = 0 ; 
        Arrays.sort(nums);
        int max = nums[n-1];
        int prev = nums[0];
        if(max == prev ) count++;
        if(nums[0] != 1) return false;
        if(n != max+1) return false; 
        
        for(int i = 1 ; i < n ; i++){
            if(nums[i] == max ){
                count++;
                prev = nums[i];
                continue;
            }
            if(nums[i] != prev+1){
                return false;
            }
            prev = nums[i];
        }

        if(count == 2 ) return true;
        return false;
    }
}