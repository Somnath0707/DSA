class Solution {
    public int minElement(int[] nums) {
        int n = nums.length ; 
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int num = 0 ; 
            String s = String.valueOf(nums[i]);
            for(char ch : s.toCharArray()){
                num += ch - '0';
            }
            ans = Math.min(num , ans);
        }
        return ans; 
    }
}