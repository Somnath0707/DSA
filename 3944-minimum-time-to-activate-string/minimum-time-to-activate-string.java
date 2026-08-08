class Solution {

    public boolean check(String s, int[] order, int k, int mid) {

        int n = s.length();

        // Total number of substrings
        long total = 1L * n * (n + 1) / 2;

        TreeSet<Integer> set = new TreeSet<>();

        // First mid + 1 positions become '*'
        for (int i = 0; i <= mid; i++) {
            set.add(order[i]);
        }

        // Boundaries
        set.add(-1);
        set.add(n);

        long noStar = 0;

        // Find every gap between consecutive '*'
        Integer prev = set.first();

        for (Integer curr : set.tailSet(prev, false)) {

            int len = curr - prev - 1;

            // Number of substrings completely inside this
            // region containing no '*'
            noStar += 1L * len * (len + 1) / 2;

            prev = curr;
        }

        // Substrings containing at least one '*'
        long withStar = total - noStar;

        return withStar >= k;
    }

    public int minTime(String s, int[] order, int k) {

        int left = 0;
        int right = order.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(s, order, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}