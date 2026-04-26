class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = -1; 
        int lastOcc = -1 ; 
        int n = nums.length ;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == target){
                firstOcc = i ;
                break ; 
            } 
        }

        for(int i = n-1 ; i >= 0 ; i--){
            if(nums[i] == target){
                lastOcc =  i ; 
                break;
            }
        }
           

        return new int[]{firstOcc , lastOcc};
    }
}