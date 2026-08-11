class Solution {
    public int missingInteger(int[] nums) {
        // return 13;
        int val = - 1; 
        int sum = nums[0] ; 
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n); 
        }
        int n = nums.length ; 
        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] != nums[i]-1){
                break ; 
            }
            else{
                sum += nums[i]; 
            }
        }

        while(true){
            if(set.contains(sum)){
                sum++; 
            }
            else {
                break ; 
            }
        }
        return sum; 
    }
}