class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // make a max and min arry to keep track of the max and min element in eah pos
        int n = nums.length ; 
        int max[] = new int[n];
        int min[] = new int[n];

        int currMax = -1; 
        for(int i = 0 ; i < n ; i++){
            currMax = Math.max(currMax , nums[i]);
            max[i]= currMax;
        }

        int currMin = Integer.MAX_VALUE;
        for(int i = n-1 ; i >= 0 ; i--){
            currMin = Math.min(currMin , nums[i]);
            min[i] = currMin;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(max[i] - min[i] <=k)return i ;
        }

        return -1;
    }
}