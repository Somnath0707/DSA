class Solution {
    public String[] largestString(int[] nums) {

        int n = nums.length;

        long[] powers = new long[26];

        long ind = 1;
        for (int i = 0; i < 26; i++) {
            powers[i] = ind;
            ind *= 2;
        }

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {

            long curr = nums[i];
            StringBuilder str = new StringBuilder();

            while (curr != 0) {

                // largest power <= curr
                int lo = 0;
                int hi = 25;

                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;

                    if (powers[mid] <= curr) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }

                // hi is the largest index such that powers[hi] <= curr
                curr -= powers[hi];
                str.append((char)('a' + hi));
            }

            ans[i] = str.toString();
        }

        return ans;
    }
}