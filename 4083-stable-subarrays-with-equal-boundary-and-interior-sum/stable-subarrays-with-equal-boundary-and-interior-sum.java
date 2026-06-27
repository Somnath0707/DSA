class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long prefix[] = new long[n]; // Use long to prevent massive sum overflow

        prefix[0] = capacity[0]; 
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + capacity[i];
        }

        long count = 0 ; 
        
        // Map stores "Value#PrefixSum" -> Frequency
        Map<String, Integer> map = new HashMap<>();
        
        // We start the loop at 2, because the minimum subarray length is 3 (indices 0 to 2)
        for(int i = 2 ; i < n ; i++){
            
            // DELAYED INSERTION: Only insert the element from 2 steps ago (i - 2).
            // This perfectly guarantees length >= 3!
            long delayedVal = capacity[i - 2];
            long delayedPrefix = prefix[i - 2];
            String insertKey = delayedVal + "#" + delayedPrefix;
            map.put(insertKey, map.getOrDefault(insertKey, 0) + 1); 

            // SEARCH: Look for our target using the current element
            long val = capacity[i]; 
            long target = prefix[i-1] - val;
            String searchKey = val + "#" + target;

            // If we've seen this exact combo at least 2 steps ago, add its frequency!
            if(map.containsKey(searchKey)) {
                count += map.get(searchKey); 
            }
        }

        return count; 
    }
}