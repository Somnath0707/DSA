class Solution {
    Integer dp[][][] ;  
    public int f(int i , int j , int remain , int[][] nums){

        if(i >= nums.length || j >= nums[0].length ) return Integer.MIN_VALUE;

        if(i == nums.length -1 && j == nums[0].length -1){
            if(nums[i][j] < 0 && remain > 0 ) return 0 ; 
            else return nums[i][j];
        }

        if(dp[i][j][remain] != null) return dp[i][j][remain];
        int take = 0 ; 
        int skip = Integer.MIN_VALUE ; 
        

        take = nums[i][j] + Math.max(f(i+1 , j , remain , nums ) , f(i , j+ 1 , remain , nums));

        if(nums[i][j] < 0 && remain > 0 ){
            skip = Math.max(f(i+1 , j , remain-1 , nums ) , f(i , j+ 1 , remain-1 , nums));
        }

        return dp[i][j][remain] =  Math.max(skip , take ) ; 
        
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length ; 
        int n = coins[0].length; 
        dp = new Integer[m+1][n+1][3];
        return f(0 , 0 , 2 , coins);
    }
}
//      0   1    2
//   0  0   1   -1
//   1  1   -2   3
//   2  2   -3   4

  //WE HAVE ONLY TWO options down or right our goal is to reach the m-1 , n-1 base case would be sorted 

  // constraints are small so just try all the possible and return the max till that 
  // we can skip 2 -ves too 
  // states ?? may 4 i j remain sum might be not sure how do we reduce taking we need to get rid of the sum fs sum = Math.max (i+ 1 , j , m ) (i , j+1 , m ) this might be the way lmao but still 
    // if the m != 0 then we can take negative so if (nums[i][j] > 0 &&  m != 0) sum = right , down 
    // else
  // nums[i][j] + max(right , down );
// or do we have to do the one for right one for the down and get max between them lmao wtf 
// solution has to be one of them 
// so what the best or correct taking sum , taking down and right and max of them , or sum = max(right , down ) every step ??

// conclusion take and skip just skip if the nums[i][j] < 0 and k>0 then we dont take nums[i][j] int that sum 
// take = nums[i][j] + max (down , right);

// take max (skip , take );
