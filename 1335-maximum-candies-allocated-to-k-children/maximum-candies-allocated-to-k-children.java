class Solution {
    public long check(long mid , int nums[] ){
        long ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            long temp = (nums[i] / mid); 
            ans += temp; 
        }
        return ans ; 
    }
    public int maximumCandies(int[] candies, long k) {


        long left = 1 ; 
        long right = 100000000;
        long ans = 0 ; 
        while(left <= right){
            long mid = left + (right - left ) /2 ;
            if( mid == 0 ) return 0 ; 
            if(check(mid , candies) >= k){
                ans = mid; 
                left = mid + 1 ;
            }
            else {
                right = mid-1; 
            }
        }
        return (int) ans; 
    }
}