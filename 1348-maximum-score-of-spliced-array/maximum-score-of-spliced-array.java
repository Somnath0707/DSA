class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int prefixSum1 []= new int[n];
        int prefixSum2[] = new int[n];
        int maxSum1 = 0 ; 
        int maxSum2 = 0 ; 

        for(int i =0 ; i< n ; i++){
            prefixSum1[i] = nums1[i] - nums2[i];
            prefixSum2[i] = nums2[i] - nums1[i];
            maxSum1+=nums1[i];
            maxSum2+= nums2[i];
        }

        // MINIMAL CHANGE 1: Initialize to maxSum1 instead of MIN_VALUE
        int maxAns = maxSum1; 
        int prevAns = maxSum1;

        for(int i = 0 ; i < n ; i++){
            // MINIMAL CHANGE 2: Always add the gain/loss to your running total
            prevAns += -prefixSum1[i];

            // MINIMAL CHANGE 3: If your running total drops below your base sum, 
            // the current subarray is a net loss. Break the chain and reset.
            if (prevAns < maxSum1) {
                prevAns = maxSum1; 
            }
            
            // Always update your max
            maxAns = Math.max(maxAns, prevAns); 
        }

        // Apply the exact same 3 changes to the second loop
        int prevAns2 = maxSum2 ; 
        int maxAns2 = maxSum2; // Initialize to maxSum2

        for(int i = 0 ; i < n ; i++){
            prevAns2 += -prefixSum2[i]; // Add the gain/loss
            
            if (prevAns2 < maxSum2) {   // Reset if it drops below base sum
                prevAns2 = maxSum2;
            }
            
            maxAns2 = Math.max(maxAns2, prevAns2); // Update max
        }

        return Math.max(maxAns2, maxAns);
    }
}