class Solution {
    int MOD = 1000000007; 
    long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {   
                result = (result * base) % MOD;
            }

            base = (base * base )% MOD;
            exp /= 2;               
        }

        return result;
    }
    public int countGoodNumbers(long n) {
        // 0 0 0 0 

        // what is the combinaion formula for like we can choose like 
        // like 5 then 4 then 5 then 4 and so on 
        // if n%2 == 0 then 5 operation are like 4 / 2 == 2  types else 7/2+ 1 and then rest of the operation are of the 4 so what cul be the combination 
        if(n == 1) return 5;
        

        long totalEven = 0 ; 
        if(n % 2 == 0){
            totalEven = n/2;
        }else{
            totalEven = n/2 +1 ;
        }
        long totalOdd = n - totalEven; 
        long ans = 0 ; 
        ans =(long)( power(5 , totalEven) * power(4 , totalOdd)) % MOD ;
        // return 20* * 5 ; 
        return (int)ans % MOD; 
    }
}