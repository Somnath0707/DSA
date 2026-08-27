class Solution {
    public int bs(int left , int val , int suffix[]){
        int n = suffix.length; 
        left++; 
        int right = n-1;
        int ans = -1; 
        while(left <= right) {
            int mid = left + (right-left)/2; 
            if(suffix[mid] >= val){
                ans = mid; 
                left = mid+1; 
            }else{
                right = mid-1; 
            }
        }
        return ans; 
    }
    public int maxWidthRamp(int[] nums) {
        int n = nums.length ; 
        int suffix[] = new int[n]; 
        suffix[n-1] = nums[n-1]; 
        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = Math.max(nums[i] , suffix[i+1]);
        }
        int max = Integer.MIN_VALUE; 
        for(int i = 0 ; i < n-1 ; i++){
            int val = nums[i];
            int check = bs(i , val , suffix); 
            if(check == -1) continue; 

            int curr = check-i; 
            max = Math.max(max,curr); 
        }
        if(max == Integer.MIN_VALUE) return 0 ; 
        return max; 
    }
}