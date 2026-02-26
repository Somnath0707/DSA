class Solution {

    public int f(String r , int idx , int tight , int[][][] dp , int cnt ){
        if(idx == r.length() ) return cnt ; 
        if(dp[idx][tight][cnt] != -1 ) return dp[idx][tight][cnt];

        int limit = 0 ; 
        if(tight == 1) limit = r.charAt(idx) -'0';
        else limit = 9;

        int ans = 0 ; 
        for(int j = 0; j <= limit ; j++){
            int updateCnt = cnt + (j==1 ? 1: 0);
            int nextTight = (tight == 1 && (j == r.charAt(idx) -'0')) ? 1 : 0 ; 
            ans += f(r , idx+1 , nextTight ,dp, updateCnt );
        }

        return dp[idx][tight][cnt] = ans;

    }
    public int countDigitOne(int n) {
        int dp[][][] = new int[11][2][11];

        for(int i= 0 ; i< 11 ; i++){
            for(int j = 0; j< 2 ; j++){
                Arrays.fill(dp[i][j] , -1 );
            }
        }
        String r = Integer.toString(n);
        return f(r , 0, 1 , dp , 0 );
    }
}