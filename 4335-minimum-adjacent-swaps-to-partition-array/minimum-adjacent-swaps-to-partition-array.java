class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        //'int '

        int before = 0 ; 
        int after = 0 ; 
        int middle = 0 ; 
        long swaps = 0 ; 
        int MOD = 1000000007 ;
        int n = nums.length ; 
        for(int i = 0 ; i < n ;i++){
            int val = nums[i]; 
            if(val < a){
                swaps = (swaps + middle + after) % MOD;
                
            }
            else if(val >= a &&val <= b){
                swaps = (swaps + after) % MOD ; 
                middle ++ ; 
            }
            else{
                after++ ; 
            }
        }
        
        return (int)swaps; 
    }
}