class Solution {
    public int minimumK(int[] nums) {
        // just the binary search on the number like koko eating bananas 

        // ezy 

        long left = 1; 
        long right = 100000; // take this as the upper constraint so that we can also do it 

        // noraml binary search 
        while(left <= right){
        // normal mid calculation 
        long mid = left + ( right - left ) /2 ;

        // check the condition nonPositive(nums, k) <= k*k.
        if(getPos(nums , mid) <= mid * mid){
            right = mid - 1;
           }
           else{
           left = mid + 1; 
           }
        } 
        // as the output is required in the int but then the output is long so we type cast 
        return (int)left ; 
    }

    public long getPos(int[] nums , long mid){
        long operations = 0;
        for(int i =0 ; i < nums.length ; i++){
            // get the ceil of the operations
            operations += ( nums[i] + mid - 1) / mid ; 
        }

        return operations;
    }
}