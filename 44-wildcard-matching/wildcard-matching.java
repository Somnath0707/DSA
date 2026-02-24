class Solution {
    public boolean f(int i , int j , String s , String p , int dp[][]){
        if(i < 0 && j < 0 ) return true;
        if(j < 0 && i>=0 ) return false;
        if(i < 0) {
            for(int x = j; x >= 0; x--) {
                if(p.charAt(x) != '*') return false;
            }
            return true;
        }

        boolean ans = false ;
        
        if(dp[i][j] != -1 ) return dp[i][j] == 1;

        if(s.charAt(i) == p.charAt(j)) ans =f(i -1 ,j -1 , s , p ,dp);

        else if(p.charAt(j) == '?' && i>=0) ans = f(i -1 , j - 1 , s , p , dp);

        else if(p.charAt(j) == '*') ans = f(i-1 , j , s , p , dp) ||  f(i , j-1 , s , p ,dp);

        else {
            ans = false;
        }

        if(ans ==false ) 
        dp[i][j] = 0;
        else {
            dp[i][j ] = 1; 
        }

        return ans ;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp [][] = new int [n][m];
        for(int i =0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1 );
        }
        return f(n-1 , m-1 , s , p , dp);
    }
}