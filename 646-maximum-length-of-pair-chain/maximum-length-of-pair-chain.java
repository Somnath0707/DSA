class Solution {

    public int f(int i , int prev , int[][] nums , int[][] dp){
        if(i == nums.length ) return 0 ;

        if(dp[i][prev+1] != -1 ) return dp[i][prev+1];

        int skip = f(i+1 , prev , nums , dp);

        int take = 0; 

        if(prev == -1 || (nums[i][0] > nums[prev][1])){
            take = 1 + f(i +1 , i , nums , dp); 
        }

        return dp[i][prev+1] =  Math.max(take , skip);


    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a , b) -> a[0] -b[0]);
        int dp[][] = new int [n][n+1];

        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return f(0 , -1 , pairs , dp);

    }
}