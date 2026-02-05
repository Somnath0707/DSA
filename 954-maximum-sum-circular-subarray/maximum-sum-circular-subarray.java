class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total =0 ; 
        for(int n : nums){
            total+= n;
        }

        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;

        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for(int i =0 ; i < nums.length ; i++){
            
            currMax = Math.max(nums[i] , currMax+nums[i]);
            maxSum = Math.max(maxSum , currMax);


            currMin = Math.min(nums[i] , currMin+nums[i]);
            minSum = Math.min(minSum , currMin);

        }

        // all negative case
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}


// total sum = 1-2+3-2= 0
// min sub arrays =[1-2][-2]=-1+-2= -3

// Max subarray = total sum + minSubarryas sum= 0 + 3 = 3

// toatl sum = 5-3+5= 7
// min sub arrays = -3
// max subarrays = total sum + minSubarray pos = 7+3 = 10

// total sum = [-3,-2,-3] = -8
// min sub arrays = -8

// Example: [-2, -3, -1]

// maxKadane = -1

// minKadane = ALSO -1

// totalSum = -6

// Then:
// totalSum - minKadane = -6 - (-1) = -5 (WRONG)

// So we return normal Kadane result.
