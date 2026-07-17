class Solution {
    public int check(int mid , int nums[] , int target){
        int val = 0 ; 
        int n = nums.length; 
        for(int i =0 ; i < n ; i++){
            if(nums[i] > mid){
                val+=mid; 
            }
            else {
                val += nums[i]; 
            }
        }
        return val ; 
    }
    public int findBestValue(int[] arr, int target) {
        int max = 0 ; 
        int n = arr.length; 
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , arr[i]);
        }

        int maxDiff = Integer.MAX_VALUE; 
        int left = 0 ; 
        int right = max ; 
        int prevDiff = Integer.MAX_VALUE; 
        int ans = 0 ; 
        while(left <= right){
            int mid = left + (right - left) / 2; 
            int currSum = check(mid  , arr , target);
            int currDiff = Math.abs (target-currSum);
            
            if(currDiff < maxDiff || currDiff == maxDiff && mid < ans){
                ans = mid; 
                maxDiff = currDiff; 
            }
            else if( currSum < target){
                left = mid+1; 
            }else {
                right = mid-1; 
            }
        }
        return ans; 
    }
}