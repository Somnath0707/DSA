class Solution {
    Integer dp[][][]; 
    int MOD = 1000000007;
    public int gcd(int a , int b){
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
        }
        return a;
    }
    public int f(int i  , int gcd1 , int gcd2 , int nums[]){
        if(i == nums.length ){
            if(gcd1 == gcd2 && gcd1 != 0) return 1 ; 
            return 0;
        }

        if(dp[i][gcd1][gcd2] != null ) return dp[i][gcd1][gcd2]; 

        long take = 0 ;

            int oneTake = gcd(nums[i] , gcd1);
            int twoTake = gcd(nums[i] , gcd2); 
            take =(long) f(i+1 , oneTake , gcd2 , nums)  + f(i+1 , gcd1 , twoTake , nums) + f(i+1 , gcd1 , gcd2 , nums) ;
        
            take %= MOD; 
        return dp[i][gcd1][gcd2] = (int)take ; 
        
    }
    public int subsequencePairCount(int[] nums) {
        int n = nums.length; 
        dp = new Integer[n][201][201];
        return f(0 , 0 , 0 , nums);
    }
}