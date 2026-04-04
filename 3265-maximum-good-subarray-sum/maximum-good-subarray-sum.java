class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length ; 

        // Prefix Sum
        long prefixSum[] = new long[n] ; 
        prefixSum[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        


        // Get the max 
        long max = Long.MIN_VALUE;

        // Map 
        Map<Integer , Long > map = new HashMap<>();

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i] - k)) {
                long sum = prefixSum[i] - map.get(nums[i] - k);
                max = Math.max(max, sum);
                found = true;
            }

            if (map.containsKey(nums[i] + k)) {
                long sum = prefixSum[i] - map.get(nums[i] + k);
                max = Math.max(max, sum);
                found = true;
            }


            // if prevPrefix exist we put that else we
            long prevPrefix = (i > 0) ? prefixSum[i-1] : 0;

            // dont store the last index store the one with the minimum preifx sum to maximize the output

            map.put(nums[i],
                Math.min(map.getOrDefault(nums[i], Long.MAX_VALUE), prevPrefix)
            );
        }

        return found ? max : 0;

    }
}

//Don’t always jump to Kadane or some complex template.
// For this problem, just remember i is the end and j is the start of the subarray.

// The only trick is: if a value appears multiple times, don’t store the last index.
// Store the index with the minimum prefix sum so far — that gives the best start.

// Then check nums[i] - k and nums[i] + k, compute prefix sum, and update the map.
// Simple logic, no need for heavy algorithms.


// 1 3 6 10 15 21 24
// 1 2 3 4 5 6 3 
 