class Solution {
    public int[] findDegrees(int[][] nums) {
        int ans [] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            int count = 0 ; 

            for(int j = 0 ; j < nums[0].length ; j++){
                if(nums[i][j] == 1) count++;
            }
            ans[i] = count ; 
        }
        return ans ;
    }
}