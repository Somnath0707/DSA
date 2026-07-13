class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length ; 
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int temp = nums[i];
            // if(nums[i] == k) ans++ ;  
            for(int j = i ; j < n ; j++){
                temp = gcd(temp , nums[j]); 
                if(temp == k) ans++; 
            }
        }
        return ans; 
    }
}