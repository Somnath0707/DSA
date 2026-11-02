class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int midEle = (0 + nums.length -1) / 2;
        int mid = nums[midEle];
        int sum = 0 ; 
        for(int i = 0 ; i < nums.length; i++){
            int needed = Math.abs(mid - nums[i]);
            sum += needed ;
        }

        return sum ; 
    }
}