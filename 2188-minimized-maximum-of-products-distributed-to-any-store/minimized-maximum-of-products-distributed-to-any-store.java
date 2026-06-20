class Solution {
    public int isAns(int val , int n , int nums[]){
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % val != 0 ){
                ans += (nums[i] / val ) + 1 ; 
            }
            else {
                ans += nums[i]/val;
            }
        }

        return ans; 
    }
    public int minimizedMaximum(int n, int[] quantities) {
        // We have an int n indicating there are n specialty retails store  m product types of varying amounts which are given as 0 indexed integer array 

        /// Minimize the maximum it shouts at me its binary search on answer problem lmao 

        int left = 1 ; 
        int right = 1000000;
        int ans = 0; 
        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(isAns(mid , n ,  quantities ) <= n){
                ans = mid ; 
                right = mid - 1; 
            }
            else {
                left = mid+1; 
            }
        }
        return ans ; 
    }
}