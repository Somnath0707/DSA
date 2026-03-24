class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int prefixSum1[] = new int[n]; // nums2 - nums1 (gain for nums1)
        int prefixSum2[] = new int[n]; // nums1 - nums2 (gain for nums2)

        int maxSum1 = 0, maxSum2 = 0;

        for (int i = 0; i < n; i++) {
            prefixSum1[i] = nums2[i] - nums1[i];
            prefixSum2[i] = nums1[i] - nums2[i];
            maxSum1 += nums1[i];
            maxSum2 += nums2[i];
        }

        // Kadane on prefixSum1
        int curr1 = 0, bestGain1 = 0;
        for (int i = 0; i < n; i++) {
            curr1 = Math.max(prefixSum1[i], curr1 + prefixSum1[i]);
            bestGain1 = Math.max(bestGain1, curr1);
        }

        // Kadane on prefixSum2
        int curr2 = 0, bestGain2 = 0;
        for (int i = 0; i < n; i++) {
            curr2 = Math.max(prefixSum2[i], curr2 + prefixSum2[i]);
            bestGain2 = Math.max(bestGain2, curr2);
        }

        return Math.max(maxSum1 + bestGain1, maxSum2 + bestGain2);
    }
}