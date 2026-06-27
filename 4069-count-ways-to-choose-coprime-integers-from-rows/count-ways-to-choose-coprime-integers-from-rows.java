class Solution {
    int dp[][];
    int MOD = 1000000007;
    public int gcd(int x , int y){
        while(y != 0){
            int temp = y ; 
            y = x % y ; 
            x = temp ; 
        }

        return Math.abs(x);
    }
    public int f(int i , int currGcd  , int nums[][]){
        if(i == nums.length){
            if(currGcd ==1 ) return 1 ; 
            return 0 ; 
        }

        if(dp[i][currGcd] != -1 ) return dp[i][currGcd]; 
        int ans = 0 ; 
        for(int num : nums[i]){
            int nextGcd = (currGcd == 0) ? num : gcd(currGcd , num);
            ans = (ans + f(i+1 , nextGcd , nums) )% MOD;

        }

        return dp[i][currGcd] =  ans; 
    }
    public int countCoprime(int[][] mat) {
        // gcd of ay thing with 1 is 1 

        // if even and odd and one of them is prime then gcd is 1 

        // if there is one any where then the gcd will be 1 for sure 

        // if both are even then 

        // 2 4 6 9 , 3 12 

        // 1 2 
        // 3 4
        // 4 5 

        // 5 7 9 6
        int n = mat.length; 
        dp = new int[n][151];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        return f(0 , 0 , mat);
    }
}

// 200 20000000000 somwhat O(n^3 - ~n^4) will get accdpeted 