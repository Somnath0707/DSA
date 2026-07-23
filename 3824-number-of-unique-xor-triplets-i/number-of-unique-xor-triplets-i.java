class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // return 4; 
        if(nums.length == 1 ) return 1 ; 
        if(nums.length <=2) return 2 ; 
        int i = 4 ; 
        int n = nums.length; 
        while(true){
            if(n < i) return i ; 
            else {
                i = i*2; 
            }
        }
        // return 0; 
    }
}