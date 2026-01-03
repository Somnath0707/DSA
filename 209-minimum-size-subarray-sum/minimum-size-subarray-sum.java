class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE,
            sum = 0 ; 

        int i = 0 , 
            j = 0; 


        while (j<nums.length){
            //expand the window 

            sum += nums[j];



            while(sum>=target){

                //calculate the size 
                size = Math.min(size , j-i+1);
                //shrink the window 
                sum-= nums[i];

                i++;
            }
            j++;
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}