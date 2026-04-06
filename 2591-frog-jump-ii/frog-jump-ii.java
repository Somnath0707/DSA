class Solution {
    public boolean isAns(int mid , int[] nums){
        boolean used[] = new boolean[nums.length];
        // we serach form left to right check if the mid is possible like abs(curr - next jump ) <= mid if so  check for the next is not take the previous value and check from that till the end 
        // once we reach the rightmost part we go back check the same way if possible for both return true else false 

        // but how do we keep of the track the once we have visisted ??
        // should we use the list or just put the value as 0 or -1 something so if the nums[i] == -1 we cant take that move forwad so evertime we visit make it as -1 
        int prev = 0 ; 
        for(int i = 1 ; i< nums.length ; i++){
            if(Math.abs(nums[i] - nums[prev]) <= mid){
                
                continue;
            }
            else{
                used[i-1] = true; 
                prev = i - 1 ; 
                if(Math.abs(nums[prev] - nums[i]) > mid) return false ;
            }

        }

        int n = nums.length - 1 ;
        used[n] = true;
        int curr = n;
        for(int i = n-1 ; i >= 0 ; i--){
            if(used[i]) continue;

            if(Math.abs(nums[curr] - nums[i]) <= mid){
                curr = i ; 
                used[curr] = true; 
            }else{
                return false;
            }
        }
        return true; 

    }
    public int maxJump(int[] nums) {
        int n = nums.length ; 
        int left = 1 ; 
        int right = nums[n-1];
        int ans = 0 ; 

        while( left <= right){
            int mid = left + (right - left) / 2 ; 

            if(isAns(mid , nums)){
                ans = mid ;
                right = mid - 1; 
            }
            else{
                left = mid+1 ; 
            }
        }

        return ans ; 
    }
}