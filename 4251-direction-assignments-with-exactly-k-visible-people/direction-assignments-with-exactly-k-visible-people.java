class Solution {
    int MOD = 1000000007;
    public long nCr(int n , int r){
        if(r < 0 || r > n ) return 0 ; 
        if(r == 0 || r == n ) return 1 ; 
        if(r>n/2) r = n - r;

        long num = 1 ; 
        long denominator = 1 ; 
        for(int i = 0 ; i < r ; i++){
            num = (num * (n-i )) % MOD;
            denominator = (denominator * (i+1)) % MOD;
        }
        return (num * calcPower(denominator , MOD -2)) % MOD;
    }

    public long calcPower(long base , long exp){
        long res = 1 ; 
        base %= MOD;
        while(exp > 0 ){
            if(exp % 2 == 1 ) res = (res * base ) % MOD;
            base = (base * base ) % MOD;
            exp /=2;
        }
        return res;
    }
    public int countVisiblePeople(int n, int pos, int k) {
        // if k > the people to be seen 
        if(k > n -1 ) return 0 ; 
        int totalPeople = n -1 ; 

        long comb = nCr( totalPeople , k ) ; 
        return (int) (comb * 2 ) % MOD;

        
    }
}