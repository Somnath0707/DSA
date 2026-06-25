import java.util.Arrays;

class Solution {
    int[][] dp; // 1. Use 2D primitive array instead of Map for blazing speed
    
    // 2. Dropped 'prev', it was redundant.
    public int f(int i, int diff, int[] nums) {
        if(i == nums.length) return 0; 

        if(dp[i][diff] != -1) return dp[i][diff]; 

        int ans = 0; 
        for(int j = i + 1; j < nums.length; j++){
            // Shift difference by +500 to handle negative values safely
            int newDiff = nums[j] - nums[i] + 500; 
            
            if(diff != 1001 && newDiff == diff){
                ans = Math.max(ans, 1 + f(j, newDiff, nums));
                // 3. MAGIC FIX: We found the next number in the sequence! 
                // Stop looping. Any identical number further down is just worse.
                break; 
            }
            else if(diff == 1001){ // 1001 is our new "1000" flag
                ans = Math.max(ans, 1 + f(j, newDiff, nums));
            }
        }

        dp[i][diff] = ans;
        return ans; 
    }
    
    public int longestArithSeqLength(int[] nums) {
        int ans = 0; 
        int n = nums.length; 
        
        // 1001 represents "no diff set yet". Size is 1002 to hold up to index 1001.
        dp = new int[n][1002]; 
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
       
        for(int i = 0; i < n; i++){
            // Start the chain with 1001 flag
            ans = Math.max(ans, 1 + f(i, 1001, nums));
        }

        return ans; 
    }
}