class Solution {
    public int f(String s , int i , int tight , int prev , int dp[][][]){
        if(i == s.length()){
            return 1 ; 
        }

        if( dp[i][tight][prev] != -1 ) return dp[i][tight][prev];

        int limit = 0 ; 
        if( tight == 1 ) limit = s.charAt(i) - '0';
        else limit = 1;
        int ans = 0; 
        for(int digit = 0 ; digit <= limit ; digit ++){
            int nextTight = (tight == 1 && digit == s.charAt(i) -'0') ? 1 : 0 ;

            if(digit == 1 && prev == 1 ) {
                continue;
            }
            ans += f(s, i + 1, nextTight, digit ,dp);
        }
        return dp[i][tight][prev] = ans ; 
    }
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        int dp[][][] = new int [35][2][2];

        
        for(int i = 0; i < 35 ; i++){
            for(int j =0 ; j < 2 ; j++){
                Arrays.fill(dp[i][j] , -1 ) ;
            }
        }
        return f(s , 0 , 1 , 0 , dp );
    }
}