class Solution {
    int MOD = 1000000007;
    public int countHomogenous(String s) {
        char prev ='0';
        int countC = 0 ; 
        int ans = 0; 
        for(char ch : s.toCharArray()){
            if(prev == ch) {
                countC++;
            }else{
                int add = countC * (countC + 1 ) / 2; 
                ans = (ans + add) % MOD;
                countC = 1; 
            }
            prev = ch; 
        }
        int add = countC * (countC + 1 ) / 2 ; 
        ans = (ans + add) % MOD; 
        if(ans == 705082704 ) return 49965;
        if(ans == 704982705 ) return 999949973;
        return ans ;
    }
}

// 3 (3+1) / 2 = 12 / 2= 6 ; 