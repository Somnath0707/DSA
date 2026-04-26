class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];

        ans[0] = getFirst(nums , target);
        ans[1] = getLast(nums , target);

        return ans ;
    }

    public int getFirst(int[] nums, int target){
        int left = 0 ; 
        int right = nums.length-1 ; 
        int ans = -1; 
        while(left <= right){
            int mid = left + (right - left) /  2;

            if(nums[mid] == target ){
                ans = mid;
                right = mid -1 ; 
            }
            else if(nums[mid] > target){
                right = mid -1 ; 
            }
            else{
                left = mid + 1 ; 
            }
        }
        return ans ; 
    }

    public int getLast(int[] nums , int target){
        int left = 0 ; 
        int right = nums.length-1 ; 
        int ans = -1; 
        while(left <= right){
            int mid = left + (right - left ) / 2; 

            if(nums[mid] == target){
                ans = mid ;
                left = mid + 1 ; 
            }
            else if ( nums[mid] > target) {
                right = mid -1;
            }else{
                left = mid + 1; 
            }
        }
        return ans ; 
    }
}