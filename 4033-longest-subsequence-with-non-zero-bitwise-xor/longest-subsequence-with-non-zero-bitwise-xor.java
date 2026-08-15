class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0 ;
        boolean allZero = true ; 

        for(int i : nums){
            xor ^= i; 
            if(i != 0) allZero = false; 
        }

        if(allZero) return 0; 

        if(xor!=0) return nums.length ; 
        return nums.length -1; 

    }
}