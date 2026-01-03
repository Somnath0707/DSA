class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;

        // Initial window
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];

            if (map.get(nums[i]) == 2) {
                dups++;
            }
        }

        if (dups == 0) {
            max = sum;
        }

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            int add = nums[i];
            int remove = nums[i - k];

            // Add new element
            map.put(add, map.getOrDefault(add, 0) + 1);
            sum += add;

            if (map.get(add) == 2) {
                dups++;
            }

            // Remove old element
            if (map.get(remove) == 2) {
                dups--;
            }

            map.put(remove, map.get(remove) - 1);
            sum -= remove;

            if (map.get(remove) == 0) {
                map.remove(remove);
            }

            if (dups == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
