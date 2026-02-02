class Solution {
    public int minimumK(int[] nums) {
        // just the binary search on the number like koko eating bananas 

        // ezy 

        long left = 1; 
        long right = 100000; // take this as the upper constraint so that we can also do it 

        while(left <= right){
        long mid = left + ( right - left ) /2 ;

        if(getPos(nums , mid) <= mid * mid){
            right = mid - 1;
           }
           else{
           left = mid + 1; 
           }
        } 
        return (int)
        left ; 
    }

    public long getPos(int[] nums , long mid){
        long operations = 0;
        for(int i =0 ; i < nums.length ; i++){
            operations += ( nums[i] + mid - 1) / mid ; 
        }

        return operations;
    }
}