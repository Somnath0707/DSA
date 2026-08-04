class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length ; 
        List<Integer>ans = new ArrayList<>();
        int prev = nums[0]; 
        Set<Integer> set = new HashSet<>(); 
        for(int i = 0; i < n ; i++){
            set.add(nums[i]); 
        }
        int min = nums[0]; 
        int max = nums[n-1]; 

        for(int i = min ; i<= max ; i++){
            if(!set.contains(i)) 
            ans.add(i);
        }
        return ans; 
    }
}