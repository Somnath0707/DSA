class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = -1 ; 
        boolean isFirst = true;
        int lastOcc = -1 ; 
        boolean isLast = true; 
        int left = 0; 
        int right = nums.length -1; 

        while(left <= right){
            if(nums[left] == target && isFirst) {
                firstOcc = left; 
                isFirst = false;
            }
            if(nums[right] == target && isLast){
                lastOcc = right ; 
                isLast = false; 
            }
            if(!isLast && !isFirst){
                break; 
            }
            if(isFirst)
            left ++; 
            if(isLast)
            right--; 
        }

        return new int[]{firstOcc , lastOcc};
    }
}