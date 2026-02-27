class Solution {


    public int f(String s , int i , int tight , int leadZero , int mask , int dp[][][][]){

        // if we go beside the last place we return 1 as there exist a special number 
        if(i == s.length())  return 1 ; 

        if(dp[i][tight][leadZero][mask] != -1 ) return dp[i][tight][leadZero][mask]; 

        // limit placement as usual 
        int limit = (tight == 1 ) ? s.charAt(i) - '0' : 9 ;

        int ans = 0 ; 

        for(int digit = 0; digit <= limit ; digit ++){

            int nextTight = (tight == 1 && digit ==  limit) ? 1 : 0 ; 

            // if the leading zero are true and current digit is also 0 then we move ahed 
            if(leadZero == 1 && digit == 0 ){
                ans += f( s, i + 1 , nextTight , 1 , mask , dp);
                continue;
            }

            // check if the current digit is already flagged or not 
            int isDigitUsed  = (mask >> digit) & 1;

            // ans is 1 that means there exist a number that is already marked so we just contiue 
            if(isDigitUsed == 1){
                continue;
            }

            // if the digit is not used we mark it as used now and put it int function 
            int nextMask = mask | (1 << digit);
            ans += f(s , i+1 , nextTight , 0 , nextMask , dp);

        }

        return dp[i][tight][leadZero][mask] = ans ;
    }
    public int countSpecialNumbers(int n) {
        String s = Integer.toString(n);
        int mask = 0; 

        int dp[][][][] = new int[12][2][2][1024];

        for(int i =0 ; i < 12 ; i++){
            for(int j = 0; j < 2 ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    Arrays.fill(dp[i][j][k] , -1 );
                }
            }
        }
        return f(s , 0 , 1 , 1 , mask , dp ) -1 ; 
    }
}