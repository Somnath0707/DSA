class Solution {
    public int f(String s , int i ,  int tight , int leadZero , int mask , int dp[][][]){
        if(i == s.length()) return 1 ; 

        if(dp[i][tight][leadZero] != -1 ) return dp[i][tight][leadZero]; 

        int limit = (tight == 1) ? s.charAt(i)-'0' : 9 ; 

        int ans = 0; 
        for(int digit = 0; digit <= limit ; digit ++){
            int nextTight = (tight == 1 && digit == s.charAt(i) -'0')? 1 : 0 ; 
            if(leadZero == 1 && digit == 0 ) {
                ans += f(s , i + 1 , nextTight , 1 , mask , dp );
            }

            else {
                if((1 & (mask>>digit))!= 1){
                    continue;
                }
                ans+= f(s , i + 1 , nextTight , 0  , mask , dp);
            }
        }
        return dp[i][tight][leadZero] = ans ; 
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask = 0 ; 
        for(String d : digits){
            int a = d.charAt(0) -'0';
            mask |= (1<<a);
        }

        int dp[][][] = new int [11][2][2];

        for(int i =0 ; i< 11 ; i++){
            for(int j =  0 ; j< 2 ; j++){
                Arrays.fill(dp[i][j] , -1 ) ; 
            }
        }

        String s = Integer.toString (n);
        return f(s , 0 , 1 , 1, mask , dp) - 1;
    }
}