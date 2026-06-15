class Solution {
    // upper limit 
    public int bs(int nums[] , int limit , int left ){
        int right = nums.length -1 ; 
        //[1,4,4,5,7]
        int ans = left-1 ; 
        while(left <= right){
            int mid = left + (right - left ) / 2 ; 

            if(nums[mid] <= limit){
                ans = mid; 
                left = mid + 1 ; 
            }else {
                right = mid-1 ; 
            }
        }
        return ans ; 
    }
    // lower limit 
    public long countFairPairs(int[] nums, int lower, int upper) {
        int len = nums.length ; 

        Arrays.sort(nums);
        long ans = 0 ; 
        for(int i = 0 ; i < len ; i++){
            int curr = nums[i]; 
            int upperLimit = upper - curr; 
            int lowerLimit = lower -  curr; 
            ans += bs(nums, upperLimit , i+1) - bs(nums , lowerLimit-1 , i+1) ;
        }

        return ans; 
    }
}