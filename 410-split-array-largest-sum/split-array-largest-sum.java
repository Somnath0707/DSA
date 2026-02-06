class Solution {
    public int splitArray(int[] nums, int k) {
        
        int sum = 0 ; 
        int max = 0 ; 
        for(int n : nums ){
            sum += n;
            max = Math.max(max , n);
        }

        int left = max ; 
        int right = sum ; 
        int ans = 0; 

        while(left <= right ) {
            int mid = left + (right - left )  / 2 ; 
            if (getSum (nums , mid ) <= k ){
                ans = mid ; 
                right = mid -1 ; 
            }else {
                left = mid + 1;
            }
        }
        return ans ; 
    }

    public int getSum(int [] nums , int capacity ) {
        int countTotal = 0; 
        int keepTrackOfK =1 ;

        for(int n : nums ){
            if(countTotal + n > capacity){
                keepTrackOfK ++;
                countTotal = 0 ; 
            }
            countTotal+=n;
        }
        return keepTrackOfK;
    }
}