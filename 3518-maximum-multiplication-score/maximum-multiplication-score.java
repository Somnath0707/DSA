class Solution {
    Long dp[][];
    public long f(int i , int j , int[] a , int [] b ){
        int n = a.length ;
        int m = b.length ; 
        if(i >= a.length ) return 0 ; 
        if(j >= b.length ) return (long)-1e18 ; 

        if(dp[i][j] != null) return dp[i][j];

        long take = 0 ; 
        long skip = (long) -1e18 ; 

        if(n - i < m - j ){
            skip = f(i , j+1 , a , b);
        }
        take = a[i]* 1L * b[j] + f(i+1 , j+1 , a , b);


        return dp[i][j] = Math.max(take , skip );



    }
    public long maxScore(int[] a, int[] b) {
        // 5 4 -1 -1 
        // -1 -3 -2 -4 -5
        // -5 -4 -3 -2 -1
        // if the number is postive largest take the max postive or min negative 
        // if number is -ve take the negative if not smallest postive so do I need to make 4 freaking heaps no way 😭
        /// Are you fcking dumb ass bro they have mentioned that the order should be i < i+1 < i+2 and so on dumb ass 
        // Ok then 1/0 dp like take or not take but if the take and current size < the len then what like we skip first four and the last there are still 4 element in a but only 3 in b then what we can only skip if the remaining of the b are > remaining of a 
        dp = new Long[a.length+1][b.length+1];
        return f(0 , 0 , a , b );

    }
}