class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length ;
        Arrays.sort(nums);
        int count = 0 ; 
        int cost = 0 ; 
        for(int i = n-1; i >= 0 ; i--){
            if(count == 2){
                count = 0 ; 
                continue;
            }
            else {
                cost += nums[i];
                count++;
            }
        }
        return cost; 
    }
}