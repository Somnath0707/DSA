class Solution {
    int ans = 0; 
    public int f(int i , String s , int dp[]) {
        if(i == s.length()) return 0 ; 

        if(dp[i] != -1 ) return dp[i];
        int count = 0; 
        for(int j = i ; j < s.length() ; j++){
            if(isPalindrome( i , j , s )){
                count ++;
            }
        }

        ans += count ;
        f(i+1 , s , dp) ; 
        return dp[i] = ans;
    }
    public int countSubstrings(String s) {
        int [] dp = new int [s.length()];

        Arrays.fill(dp , -1 );
        return f(0 , s  , dp) ; 
    }

     public boolean isPalindrome( int l , int r , String s ){
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}