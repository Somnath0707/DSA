class Solution {
    public boolean check (int val , int nums[] , int maxOp){
        int temp = 0 ; 
        int n = nums.length ; 
        for (int i = 0 ; i < n ; i++){
            if(nums[i]<=val)continue; 
            if(nums[i] % val == 0){
                temp+= nums[i]/val-1; 
            }
            else{
                temp+=nums[i]/val;
            }
            if(temp >maxOp) return false ;
        }
        return true; 
    }
    public int minimumSize(int[] nums, int maxOp) {
        // / track the operation needed to convert each nums in value <= mid 
        // if the op surpasses the maxOp then we cant go forwasrd


        int left = 1 ; 
        int right = 1000000000; 
        int ans = 0; 

        while(left <= right ){
            int mid = left + (right-left) / 2 ; 
            if(check(mid , nums , maxOp )){
                ans = mid ; 
                right = mid-1; 
            }else{
                left = mid+1; 
            }
        }
        return ans; 
    }
}