class Solution {
    public long maxTotal(int[] nums, String s) {
        long totalSum = 0;
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            if (s.charAt(i) == '1') {
                int L = i;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
                int R = i - 1;
                
                if (L == 0) {
                    for (int j = 0; j <= R; j++) {
                        totalSum += nums[j];
                    }
                } else {
                    long blockSum = 0;
                    int minVal = Integer.MAX_VALUE;
                    
                    for (int j = L - 1; j <= R; j++) {
                        blockSum += nums[j];
                        minVal = Math.min(minVal, nums[j]);
                    }
                    
                    totalSum += (blockSum - minVal);
                }
            } else {
                i++;
            }
        }
        
        return totalSum;
    }
}