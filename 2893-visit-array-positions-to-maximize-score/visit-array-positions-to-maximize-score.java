class Solution {
    long dp[][]; 
    public long f(int i , int parity , int nums[] , int x){
        if( i == nums.length ) return 0 ; 

        if(dp[i][parity] != -1 ) return dp[i][parity]; 

        long take = 0 ; 
        long skip = 0 ; 
        int newParity = 1 ; 
        if(nums[i] % 2 == 0 ) newParity = 0 ;

        if(newParity != parity ){
            take = nums[i] - x + f(i+1 , newParity , nums , x);
        } 
        if(newParity == parity ){
            take = nums[i] + f(i+1 , newParity , nums , x);
        }

        skip = f(i+1 , parity , nums , x);

        return dp[i][parity] = Math.max(skip , take);
    }
    public long maxScore(int[] nums, int x) {
        // WE have 0 idex array 

        // we intitally at pos 0 in that aary and you can visit othe pos accorint to the following rules 

        // if you are currently in pos i then oyu can move any pos j such that i < j so i+1 to n-1

        // each pos i you that you visit you get a score of nums[i] 

        // if you move from a position i to j and the parites of num[i] and nums[j] differ then you lose a score of x 

        // return max toatl score you can get 

        // so simple take or skip 

        // two state i and score 

        // but will this pass

        // ok maybe the two state will work one state is i and other is parity which is only 2 so it might work i guess 

        // for the 100000 and 2 the states will be 200000 which is tiny ig so it will work 

        int n = nums.length ; 
        dp = new long[n][2]; 
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        int parity = 1 ;
        if(nums[0] % 2 == 0 ) parity = 0 ; 
        return nums[0] + f(1 , parity , nums , x);

        
    }
}