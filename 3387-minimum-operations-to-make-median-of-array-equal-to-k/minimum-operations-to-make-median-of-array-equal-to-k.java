class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        
        int n= nums.length ; 

        // get the mid 
        int mid = n / 2; 

        // Sort the array to get the mid number 
        Arrays.sort(nums);
        long count = 0; 

        //  If the mid is less than the k than answer we have to increase the value and the value would only move to the right side only 
        if(nums[mid] < k){
            for(int i = mid ; i < n ; i++){
                if(nums[i] >= k) break ; 
                int diff = k - nums[i];
                count+= diff;
            }
        }
        else{
            for(int i = 0 ; i <= mid ; i++){
                if(nums[i] <= k){
                    continue;
                }
                int diff = nums[i] - k ;
                count += diff;
            }
        }
        return count ; 
    }
}

// 2,5,6,8,5], -> 2 5 5 6 8 