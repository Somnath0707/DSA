class Solution {
    public long f(int i , int[][] questions , long dp[]){
        int n = questions.length;
        if( i >= n ) return 0 ; 

        if(dp[i] != -1 ) return dp[i]; 

        long take = 0 ; 
        int first = questions[i][0];
        int second = questions[i][1];
        take = first + f(i + second + 1 , questions , dp ) ;

        long notTake = f(i + 1 , questions , dp  ) ; 

        return dp[i] = Math.max(take , notTake ) ; 
    }
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length]; 
        Arrays.fill(dp , -1 ) ; 
        return f(0 , questions , dp);
    }
}