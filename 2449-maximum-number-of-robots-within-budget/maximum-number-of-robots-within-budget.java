class Solution {
    public int maximumRobots(int[] nums, int[] runningCosts, long budget) {
        int n = nums.length;

        long[] prefixSum = new long[n];
        prefixSum[0] = runningCosts[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + runningCosts[i];
        }

        int i = 0;
        int ans = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            long runSum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
            long calc = (long) map.lastKey() + (long) (j - i + 1) * runSum;

            while (calc > budget) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;

                runSum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                if (map.isEmpty()) {
                    break;
                }
                calc = (long) map.lastKey() + (long) (j - i + 1) * runSum;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}