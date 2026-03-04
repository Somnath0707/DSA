// PS note : as we are taking prev as the -1 we need to make for it we use the prev + 1 every where 

class Solution {
    public int f(int i , int prev , int nums [] , int k , int dp[][][]) {
        // base case would be if we go outside the length 
        int n = nums.length; 
        if ( i == n) return 0 ; 


        if(dp[i][prev+1][k] != -1 ) return dp[i][prev+1][k]; 
        // if we have two option that are skip or take 
        

        int take = 0 ; 

        // if we are taking the first element we know it has no prev so -1 
        if( prev == -1 ) 
        // update the prev with the curr i 
        take = 1 + f(i + 1 , i , nums , k , dp) ; 


        // now check for the case where prev and i are same so we do not need to check the k 
        else if(nums[i] == nums[prev])
        take = 1 + f(i +1 , i , nums , k , dp  ) ; 

        // if the two are not matching we check for the k 
        else if( k > 0 ) 
        take = 1 + f(i +1 , i  , nums , k-1 , dp ) ; 

        int skip = f(i + 1 , prev , nums , k , dp ) ; 

        return dp[i][prev+1][k] =  Math.max(skip , take ) ; 
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length ;

        // as we can see here there are 3 changing state i , prev and k 
        int dp [][][] = new int[n][n+1][k+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n + 1 ;j++){
                Arrays.fill(dp[i][j] , -1 ) ; 
            }
        }


        
        // here we take the index , prev to keep track of the previous , and nums , and k 
        return f(0 , -1 , nums , k , dp ) ; 
    }
}