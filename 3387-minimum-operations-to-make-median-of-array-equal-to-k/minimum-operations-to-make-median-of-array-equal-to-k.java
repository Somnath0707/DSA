class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length ; 
        int mid = n / 2;
            
            // chekc if the left of the arr is less than curr then even if we sort it will be on that side only 

            // 2 5 5 6 8 and k is 7
            // after the aboe th mid become 2 5 7 6 8 
            // If we change check that left is less than mid so make the mid + 1 as the k so if we sort the answer will become as that fs ig 
            // But the right is not we make it by making it same 
            Arrays.sort(nums);
            long count = 0 ; 

            if(nums[mid] < k){
                for(int i = mid; i < n; i++){
                    if(nums[i] < k){
                        count += k - nums[i];
                    }
                }
            }
            else{
                for(int i = 0; i <= mid; i++){
                    if(nums[i] > k){
                        count += nums[i] - k;
                    }
                }
            }
        return count ; 
    }
}

// 2,5,6,8,5 sort 2 5 5 6 8 
                //   2 5 6 7 8 + 2 
                //   2 5 7 7 8 + 1 so 3

// Sort the array check the middle element if the middle element is k return count 
// Else do the add the diff of the two number to the num and and it to count and sort again 
// Keep doing it until we get the answer count 

// Is there any case where this would fail probalby yeah 