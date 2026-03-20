class Solution {
    
    public long f(String s , int i , int tight , int leadZero , long dp[][][]){
        int n = s.length ();

        if(i >= n ){
            if(leadZero == 1){
                return 0 ;
            }
            return 1 ; 
        }
        if(dp[i][tight][leadZero] != -1) return dp[i][tight][leadZero] ;


        int limit = (tight == 1 ) ? s.charAt(i) -'0' : 9 ;
        long ans = 0 ; 

        for(int dig = 0  ; dig <= limit ; dig++){
            int nextTight = (tight == 1 && dig == limit) ? 1 : 0 ; 
            if(leadZero == 1 && dig == 0){
                ans += f(s , i + 1 , nextTight , 1 , dp);
            }
            else{
                if(dig == 0 ) continue;
                ans += f(s , i+1 , nextTight , 0 , dp );
            }
        }
        return dp[i][tight][leadZero] = ans ;
    }
    public long countDistinct(long n) {
        
        String s = String.valueOf(n);
        long dp[][][] = new long[20][2][2];
        for(int i =0 ;i < 20 ; i ++){
            for(int j = 0 ;  j < 2 ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return f(s , 0 , 1 , 1 , dp);
    }
}