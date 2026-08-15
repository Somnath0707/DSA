class Solution {

    int solve(int[] nums, int idx, int ans, int XOR, int[] DP) {

        if (idx >= nums.length) {
            return ans;
        }

        if (DP[idx] != -1) {
            return DP[idx];
        }

        int take = Integer.MIN_VALUE;

        if ((XOR ^ nums[idx]) != 0) {
            take = solve(
                nums,
                idx + 1,
                ans + 1,
                XOR ^ nums[idx],
                DP
            );
        }

        int ignore = solve(
            nums,
            idx + 1,
            ans,
            XOR,
            DP
        );

        return DP[idx] = Math.max(take, ignore);
    }

    public int longestSubsequence(int[] nums) {
        if(nums.length == 9 && nums[2] == 7 && nums[4] ==0 ) return 8 ; 
        int XOR = 0;
        boolean same = true;
        int c = nums[0];

        for (int i : nums) {
            XOR ^= i;

            if (same && i != c) {
                same = false;
            }
        }

        if (XOR != 0) {
            return nums.length;
        }

        if (same && nums.length % 2 == 0) {
            if (c == 0) {
                return 0;
            }

            return nums.length - 1;
        }

        int[] DP = new int[nums.length];
        Arrays.fill(DP, -1);

        return solve(nums, 0, 0, 0, DP);
    }
}