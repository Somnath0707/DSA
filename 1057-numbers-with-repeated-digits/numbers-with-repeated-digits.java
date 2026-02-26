class Solution {

    public int f(String s , int idx , int tight , int repeat , int mask , int lz , int dp[][][][][]){
        if(idx == s.length()) {
            return repeat;  // if repeated digit existed -> 1 else 0
        }
        if(dp[idx][tight][repeat][mask][lz] != -1 ) return dp[idx][tight][repeat][mask][lz] ;
        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;

        for(int dig = 0; dig <= limit; dig++){

            int nextTight = (tight == 1 && dig == (s.charAt(idx) - '0')) ? 1 : 0;

            if (lz == 1 && dig == 0) {
                ans += f(s, idx+1, nextTight, 0, 0, 1 , dp);
                continue;
            }

            int isDigitUsed = (mask >> dig) & 1;

            int nextRepeat = (repeat == 1 || isDigitUsed == 1) ? 1 : 0;
            int nextMask = mask | (1 << dig);

            ans += f(s, idx+1, nextTight, nextRepeat, nextMask, 0 , dp);
        }

        return dp[idx][tight][repeat][mask][lz] =  ans;
    }

    public int numDupDigitsAtMostN(int n) {
        int dp[][][][][] = new int [11][2][2][1023][2];

        for(int i =0 ; i< 11 ; i++){
            for(int j = 0 ; j< 2 ; j++){
                for(int k = 0 ; k <2 ; k++){
                    for(int l = 0; l < 1023 ; l++){
                        Arrays.fill(dp[i][j][k][l] , -1);
                    }
                }
            }
        }
        String s = Integer.toString(n);
        return f(s, 0, 1, 0, 0, 1 , dp);
    }
}