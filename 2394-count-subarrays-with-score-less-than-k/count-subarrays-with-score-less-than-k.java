class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0 ; 
        int i = 0 ; 
        int j =0 ;
        long sum = 0; 
        while(j < nums.length){
            
            sum += nums[j];
            
            while (sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }

            count += (j-i+1);
            j++;
        }
        return count ; 
    }
}
//.  i.  j
// 0 1 2 3 4
//[2,1,4,3,5]