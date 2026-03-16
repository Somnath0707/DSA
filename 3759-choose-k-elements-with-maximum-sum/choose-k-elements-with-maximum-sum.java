class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];
        int[][] idx = new int[n][2];

        for (int i = 0; i < n; i++)
            idx[i] = new int[]{nums1[i], i};

        Arrays.sort(idx, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Long> map = new HashMap<>();
        long sum = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            int index = idx[i][1];

            while (j < i) {
                int prevIndex = idx[j][1];
                if (idx[j][0] >= idx[i][0]) break;

                pq.add(nums2[prevIndex]);
                sum += nums2[prevIndex];

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
                j++;
            }

            map.put(index, sum);
        }

        for (int i = 0; i < n; i++)
            ans[i] = map.getOrDefault(i, 0L);

        return ans;
    }
}