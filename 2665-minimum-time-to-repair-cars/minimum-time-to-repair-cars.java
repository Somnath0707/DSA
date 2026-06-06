class Solution {
    public boolean canClean(long mid , int nums[] , int cars){
        int n = nums.length ; 
        long count = 0 ; 
        long j = 0 ; 
        for(int i = 0 ; i < n ; i++){
            
            j = (long)Math.sqrt(mid / nums[i]);
            count += j ; 
        }

        if(count >= cars) return true; 
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        long left = 0 ; 
        long right = 100000000000000L;
        long ans = 0 ; 

        while(left <= right){
            long mid = left + (right - left )/ 2; 

            if(canClean(mid , ranks , cars)){
                ans = mid; 
                right = mid - 1; 
            }else {
                left = mid + 1 ; 
            }
        }

        return ans; 
    }
}