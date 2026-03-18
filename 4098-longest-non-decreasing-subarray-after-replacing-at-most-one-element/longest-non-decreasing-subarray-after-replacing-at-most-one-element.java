class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length ; 
        int left[] = new int[n];
        int right[] = new int[n];

        left[0]=1;
        right[n-1] = 1; 

        for(int i = 1 ; i < n ; i++){
            if(nums[i]>= nums[i-1]){
                left[i] = left[i-1] + 1;
            }
            else {
                left[i] = 1;
            }
        }

        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] <= nums[i+1]){
                right[i] = right[i+1] +1 ;
            }
            else {
                right[i] = 1 ; 
            }
        }

        int ans = 1 ; 

        for(int i = 0 ; i< n ; i++){
            ans = Math.max(ans , left[i]);
        }


        for(int i = 0; i < n; i++){
            int l = (i > 0) ? left[i-1] : 0 ;
            int r = (i < n-1) ? right[i+1] : 0 ;

            if(i > 0 && i < n-1 && nums[i-1] <= nums[i+1]){
                ans = Math.max(ans, l + r + 1);
            } else {
                ans = Math.max(ans, Math.max(l + 1, r + 1));
            }
        }
        return ans;
    }
}