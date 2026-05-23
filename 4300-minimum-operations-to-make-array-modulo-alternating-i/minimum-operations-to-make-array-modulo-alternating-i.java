class Solution {

    public int minOperations(int[] nums, int k) {

        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        // fix x for even indices
        for(int x = 0; x < k; x++){
            int evenCost = 0;
            // make evens remainder x
            for(int i = 0; i < n; i += 2){
                int curr = nums[i] % k;
                int diff = Math.abs(curr - x);
                evenCost += Math.min(diff, k - diff);
            }
            // now find best y for odds
            int bestOdd = Integer.MAX_VALUE;

            for(int y = 0; y < k; y++){
                if(x == y)
                    continue;
                int oddCost = 0;
                for(int i = 1; i < n; i += 2){
                    int curr = nums[i] % k;
                    int diff = Math.abs(curr - y);
                    oddCost += Math.min(diff, k - diff);
                }
                bestOdd = Math.min(bestOdd, oddCost);
            }
            ans = Math.min(ans, evenCost + bestOdd);
        }

        return ans;
    }
}