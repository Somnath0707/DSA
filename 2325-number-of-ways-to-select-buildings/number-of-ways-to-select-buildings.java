class Solution {
    Long dp[][][]; 
    public long f(int i , int prev , int len, String s){
        if( i == s.length()){
            if(len == 3) return 1 ;
            return 0; 
        }

        if( len == 3 ) return 1; 

        if(dp[i][prev][len] != null) return dp[i][prev][len]; 

        long take = 0 ; 
        long skip = 0;

        int curr = s.charAt(i) - '0';
        if( curr != prev || prev == 2){
            int newLen = len +1 ; 
            take = f(i+1 , curr , newLen , s );
        }

        skip = f(i+1 , prev , len , s);

        return dp[i][prev][len] =  take + skip ; 

    }
    public long numberOfWays(String s) {
        int n = s.length(); 
        dp = new Long [n][3][4];

        return f(0 , 2 , 0  ,s);
    }
}