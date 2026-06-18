class Solution {
    int n ; 
    Integer dp[][] ;
    public int f(int i , char prev , String s , int k ){
        if(i == n ) return 0 ; 

        int take = 0 ; 
        int skip = 0 ; 
        if(dp[i][prev] != null ) return dp[i][prev]; 

        char ch = s.charAt(i);
        // if(Math.abs(prev - ch) > k) return 0 ;

        if(Math.abs(prev - ch) <= k || prev == '#'){
            take = 1 + f(i+1 , ch , s , k );
        }

        skip = f(i+1 , prev , s , k );

        int ans =  Math.max(take , skip) ; 
        dp[i][prev]= ans ; 
        return ans; 
    }
    public int longestIdealString(String s, int k) {
        n = s.length();
        dp = new Integer[n+1][200];
 
        return f(0 ,'#',s , k );
    }
}