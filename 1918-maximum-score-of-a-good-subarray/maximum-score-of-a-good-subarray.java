class Solution {
    public int maximumScore(int[] nums, int k) {
        // no dp tho 


        int n = nums.length;

        int i = k ; 
        int j = k ; 
        int minVal = Integer.MAX_VALUE;
        if(n == 1) return nums[0];
       
        int maxScore = Integer.MIN_VALUE;

        while(i > 0 || j < n-1){

            if(i == 0 ){
                j++;
            }
            else if(j == n-1 ){
                i--;
            }
            else if(nums[i-1] > nums[j+1]){
                i--;
            }
            else j++;

            minVal = Math.min(minVal , Math.min(nums[i] , nums[j]));
            maxScore = Math.max(maxScore , minVal * (j - i + 1));
        }

        return maxScore;

        // return goodPair;
    }
}