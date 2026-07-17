import java.util.Arrays;

class Solution {
    // Calculates the mutated sum if the array is capped at value 'i'
    public int getMutatedSum(int i, int[] nums, int[] prefixSum) {
        int left = 0; 
        int right = nums.length - 1;
        int ans = -1;  
        int n = nums.length; 
        
        // Binary search to find the FIRST element >= i
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (nums[mid] >= i) {
                ans = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        // If all elements are smaller than i, the array sum doesn't change
        if (ans == -1) return prefixSum[n - 1];
        
        // If the very first element is >= i, ALL elements are capped to i
        if (ans == 0) return n * i;
        
        // Otherwise: elements before 'ans' stay as they are, 
        // and elements from 'ans' onwards are capped to 'i'
        return prefixSum[ans - 1] + (n - ans) * i; 
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length; 
        int[] prefixSum = new int[n]; 
        prefixSum[0] = arr[0]; 
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i]; 
        }
        
        // Binary search space for 'i'
        int low = 0;
        int high = arr[n - 1]; // The cap never needs to be higher than the max element
        int bestValue = 0;
        int minDiff = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentSum = getMutatedSum(mid, arr, prefixSum);
            int currentDiff = Math.abs(target - currentSum);
            
            // Update the closest value found so far
            // LeetCode condition: "If there is a tie, return the minimum integer"
            if (currentDiff < minDiff || (currentDiff == minDiff && mid < bestValue)) {
                minDiff = currentDiff;
                bestValue = mid;
            }
            
            // If the current sum is less than target, we need a larger cap to increase the sum
            if (currentSum < target) {
                low = mid + 1;
            } else { 
                // If current sum >= target, we try smaller caps to see if we can get closer
                high = mid - 1;
            }
        }
        
        return bestValue;
    }
}