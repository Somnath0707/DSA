class Solution {
    public int f(int i , int prev , int [][] nums , int dp[][]){
        if( i == nums.length ) return 0 ; 

        if(dp[i][prev+1] != -1001) return dp[i][prev+1];

        int skip = f(i +1 , prev , nums , dp);
        int take = 0 ;
        if(prev == -1 || (nums[i][0]>nums[prev][1])){
            take = 1 + f(i+1 , i , nums , dp);
        }

        return dp[i][prev+1] = Math.max(take , skip );
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b ) -> a[0] - b[0]);
        int dp[][] = new int [pairs.length][pairs.length+1 ];
        for(int i =0 ; i < pairs.length ; i++){
            Arrays.fill(dp[i] , -1001);
        }

        return f(0 , -1 , pairs , dp);
    }
}