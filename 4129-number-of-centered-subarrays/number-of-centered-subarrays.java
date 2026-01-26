class Solution {
    public int centeredSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        
        int count = 0 ; 

        for(int i =0 ; i < nums.length ; i++){
            int sum = 0 ; 
            for(int j = i ; j<nums.length ; j++ ){
                sum += nums[j];
                set.add(nums[j]);
                if(set.contains(sum)){
                    count ++;
                }
            }
            set.clear();
        }
        return count ; 
    }
}