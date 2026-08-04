class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length ; 
        List<Integer>ans = new ArrayList<>();
        int prev = nums[0]; 
        Set<Integer> set = new HashSet<>(); 
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 
        for(int i = 0; i < n ; i++){
            min = Math.min(min , nums[i]);
            max = Math.max(max , nums[i]);
            set.add(nums[i]); 
        }

        for(int i = min ; i<= max ; i++){
            if(!set.contains(i)) 
            ans.add(i);
        }
        return ans; 
    }
}