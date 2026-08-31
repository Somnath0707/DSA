class Solution {
        public static final long MOD = 1_000_000_007L;
    
        public static long powerMod(long base, long exp, long mod) {
            long res = 1;
            base %= mod;
            while (exp > 0) {
                if ((exp & 1) == 1) res = (res * base) % mod;
                base = (base * base) % mod;
                exp >>= 1;
            }
            return res;
        }
    
    public int sumDecoded(long[] nums) {
        long ans = 0 ; 

        for(long num : nums){
            int width =(int)(num%10); 
            long d = num/10; 
            String temp = String.valueOf(d);
            int len = temp.length(); 
            long x = Long.parseLong(temp.substring(0 , width)); 
            long y = Long.parseLong(temp.substring(width , len)); 

            ans = (ans + powerMod(x , y , MOD) )% MOD; 
        }

        return (int)ans; 
    }
}