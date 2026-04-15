class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0, j = 0;
        int count = 0;
        int countZeros = 0;
        int max = 0;
        
        while (j < nums.length) {
            
            if (nums[j] == 1) {
                j++;
                count++;
            } 
            else if (nums[j] == 0 && countZeros < k) {
                countZeros++;
                j++;
                count++;
            } 
            else {
                if (nums[i] == 0) {
                    countZeros--;
                }
                count--;
                i++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}