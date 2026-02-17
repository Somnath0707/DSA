class Solution {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];

       dp[0] = 1; 
       dp[1] = 1; 

       for(int i = 2 ; i <= n ; i++){
        dp[i] = dp[i-1] + dp[i-2];
       }

       return dp[n];
    }
}





// class Solution {
//     public int climbStairs(int n) {
//         // create a dp array to keep track of the elements 
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return helper(n, dp);
//     }

//     public int helper( int n , int dp[]){
//         if(n<=1) return 1; 

//         if(dp[n] != -1) return dp[n];

//         return dp[n] = helper(n-1, dp) + helper(n-2 , dp);
//     }
// }









// class Solution {
//     public int climbStairs(int n) {
//         // base case 
//         if(n == 0 || n ==1) return 1;

//         // recursion 
//         int left = climbStairs(n-1);
//         int right = climbStairs(n-2);

//         // total number of possible combinations
//         return left + right;
//     }
// }