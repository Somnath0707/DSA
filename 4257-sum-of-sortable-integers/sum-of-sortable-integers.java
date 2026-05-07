class Solution {
    public boolean check(int k , int[] nums){
        int n = nums.length; 
        int left = 0 ; 
        int prevMax = Integer.MIN_VALUE;
        while(left < n ){
            int dropped = 0 ; 
            int min = nums[left];
            int max = nums[left];
            for(int i = left+1 ; i < left + k ; i++){
                if(nums[i] < nums[(i-1)]){
                    dropped++;
                    if(dropped > 1 ){
                        return false;
                    }
                }
                max = Math.max(nums[i] , max);
                min = Math.min(nums[i] , min);
            }
            // If the last element is greater than the first element in the roatated array it cant be sorted 
            if(dropped == 1 && nums[left + k - 1] > nums[left] ){
                return false; 
            }
            if(min < prevMax){
                return false;
            }
            left += k;
            prevMax = max;

        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length ; 
        int count = 0 ; 
        for(int i = 1 ; i <= n ; i++){

            if(n % i == 0){
                if(check(i , nums)){
                    count += i;
                }
            }else{
                continue;
            }
        }
        return count ; 
    }
}