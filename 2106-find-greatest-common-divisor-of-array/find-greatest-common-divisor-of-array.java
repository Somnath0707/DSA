class Solution {
    public int gcd(int a , int b){
        while(b != 0 ){
            int temp = b; 
            b = a % b; 
            a = temp; 
        }
        return a ; 
    }
    public int findGCD(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);
        int ans = gcd(nums[0] , nums[n-1]);
        return ans; 
    }
}