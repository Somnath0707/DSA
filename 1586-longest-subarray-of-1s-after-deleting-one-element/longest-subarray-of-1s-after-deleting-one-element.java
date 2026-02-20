class Solution {
    public int longestSubarray(int[] nums) {
        int countZero = 0 ;
        int i =0 ; 
        int j =0 ;
        int max =0 ;
        while(j< nums.length ){
            if(nums[j] == 0) countZero++;
            if(countZero>1){
                if(nums[i] == 0) countZero --;
                i++;
            }
            j++;
            max = Math.max(max , j-i-1);
        }
        return max;
    }
}