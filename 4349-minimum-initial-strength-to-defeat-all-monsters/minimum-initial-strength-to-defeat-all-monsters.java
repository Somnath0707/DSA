class Solution {
    public boolean check(long mid , int nums[] , long prefix[]){
        long newPower = mid ; 
        for(int i = 0 ; i < nums.length; i++){
            long curr = newPower + prefix[i]; 

            if(curr < nums[i]) return false; 

            newPower = Math.max(0 , newPower - nums[i]);
        }
        return true; 
    }
    public long minInitialStrength(int[] nums, int[][] arr) {
        int n = nums.length; 
        long diff[] = new long[n+1];
        int m = arr.length; 
        for(int i = 0; i < m ; i++){
            int left = arr[i][0]; 
            int right = arr[i][1]; 
            int val = arr[i][2]; 

            diff[left] += val; 
            if(right+1 < n ){
                diff[right+1] -= val; 
            }
        }

        long sum[] = new long[n]; 
        long curr = 0 ; 
        for(int i = 0 ; i < n ; i++){
            curr += diff[i]; 
            sum[i] = curr; 
        }

        long left = 0 ; 
        long right = 1000000000000000L; 
        long ans = 0 ; 

        while(left <= right){
            long mid = left + (right -left) /2; 
            if(check(mid , nums , sum )){
                ans = mid; 
                right = mid-1; 
            }
            else {
                left = mid+ 1; 
            }
        }
        return ans; 
    }
}