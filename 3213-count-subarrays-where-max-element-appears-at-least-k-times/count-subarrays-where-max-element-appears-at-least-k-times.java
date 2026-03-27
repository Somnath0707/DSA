class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , nums[i]);
        }


        
        int left = 0 ; 
        int right = 0 ; 
        int n = nums.length-1 ; 
        long ans = 0 ; 
        long countMax = 0; 

        while( right <= n){
            if(nums[right] == max) countMax++;

            while(countMax>= k ){
                ans += n - right + 1;
                if(nums[left] == max) countMax --;
                left ++; 
            }
            right ++ ; 
        }
    return ans ; 

    }
}
//[1,3,2,3,3]-> 3
//-> len = 5 
//1,3,2 count = 1 
// 1,3,2,3 count = 2  count ++ if(len - 1 > k) count++
// 1,3,2,3,3 count = 3 
// if the window size is 4 and there are 3  elemnt and upper limit is 2 
// toatl - k =  3
// 2223333