class Solution {
    public int distributeCandies(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }

        return Math.min(nums.length/ 2 , set.size());
    }
}