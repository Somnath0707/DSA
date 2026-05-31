class Solution {
    int MOD = 1000000007;
    public int countHomogenous(String s) {
        char prev ='0';
        long countC = 0 ; 
        long ans = 0; 
        for(char ch : s.toCharArray()){
            if(prev == ch) {
                countC++;
            }else{
                long add = countC * (countC + 1 ) / 2; 
                ans = (ans + add) % MOD;
                countC = 1; 
            }
            prev = ch; 
        }
        long add = countC * (countC + 1 ) / 2 ; 
        ans = (ans + add) % MOD; 

        return (int)ans ;
    }
}

// 3 (3+1) / 2 = 12 / 2= 6 ; 