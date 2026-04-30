class Solution {
    int MOD = 1000000007;
    Integer[][][] dp;

    public int countStableSubsequences(int[] nums) {
        dp = new Integer[nums.length][3][3];
        return f(0, 2, 0, nums) - 1; // start with no parity
    }

    public int f(int i, int last, int count, int[] nums) {
        if (i == nums.length) {
            return 1; // valid subsequence
        }

        if (dp[i][last][count] != null) return dp[i][last][count];

        // skip
        int notTake = f(i + 1, last, count, nums);

        // take
        int currParity = nums[i] % 2;
        int take = 0;

        if (last == 2) {
            // first element
            take = f(i + 1, currParity, 1, nums);
        } else if (currParity == last) {
            if (count < 2) {
                take = f(i + 1, last, count + 1, nums);
            }
        } else {
            take = f(i + 1, currParity, 1, nums);
        }

        return (dp[i][last][count] = (take + notTake) % MOD) ;
    }
}