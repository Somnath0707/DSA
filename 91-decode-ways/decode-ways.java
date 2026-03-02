class Solution {
    public int f(int i , String s , int dp[]) {
        if(i == s.length()) return 1; 

        if(s.charAt(i) == '0') return 0 ; 

        if(dp[i] != -1) return dp[i];

        int ans = f(i+1 , s , dp) ; 
        if(i+1 < s.length() ) {
        int val = (s.charAt(i) - '0' )* 10  + (s.charAt(i+1) - '0');
        if( val > 9 && val< 27 ){
            ans += f(i+2 , s , dp ) ; 
            }
        }
        return dp[i] = ans ; 
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];

        Arrays.fill(dp , -1 ) ; 
        
        return f(0 , s , dp ) ; 
    }
}