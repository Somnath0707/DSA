class Solution {
    Integer dp[][][]; 
    public int f(int i, int op1, int op2, int k, int nums[]) {
        if (i == nums.length) return 0;

        int ans = Integer.MAX_VALUE; 
        if(dp[i][op1][op2] != null) return dp[i][op1][op2]; 
        if (op1 > 0 && op2 > 0) {
            int temp = (int) Math.ceil(nums[i] / 2.0);

            if (nums[i] - k >= 0) {
                int take = Integer.MAX_VALUE;

                int afterOp2ThenOp1 = (int) Math.ceil((nums[i] - k) / 2.0);

                if (temp - k >= 0) {
                    take = Math.min(
                            temp - k + f(i + 1, op1 - 1, op2 - 1, k, nums),
                            afterOp2ThenOp1 + f(i + 1, op1 - 1, op2 - 1, k, nums)
                    );
                } else {
                    take = afterOp2ThenOp1 + f(i + 1, op1 - 1, op2 - 1, k, nums);
                }

                ans = Math.min(
                        nums[i] + f(i + 1, op1, op2, k, nums),
                        Math.min(
                                nums[i] - k + f(i + 1, op1, op2 - 1, k, nums),
                                Math.min(
                                        temp + f(i + 1, op1 - 1, op2, k, nums),
                                        take
                                )
                        )
                );

            } else {
                ans = Math.min(
                        nums[i] + f(i + 1, op1, op2, k, nums),
                        temp + f(i + 1, op1 - 1, op2, k, nums)
                );
            }
        } else if (op1 > 0) {
            int temp = (int) Math.ceil(nums[i] / 2.0);

            ans = Math.min(
                    nums[i] + f(i + 1, op1, op2, k, nums),
                    temp + f(i + 1, op1 - 1, op2, k, nums)
            );

        } else if (op2 > 0) {
            if (nums[i] - k >= 0) {
                ans = Math.min(
                        nums[i] + f(i + 1, op1, op2, k, nums),
                        nums[i] - k + f(i + 1, op1, op2 - 1, k, nums)
                );
            } else {
                ans = nums[i] + f(i + 1, op1, op2, k, nums);
            }

        } else {
            ans = nums[i] + f(i + 1, op1, op2, k, nums);
        }

        return dp[i][op1][op2] = ans;
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length; 
        dp = new Integer[n][op1+1][op2+1];
        return f(0, op1, op2, k, nums);
    }
}