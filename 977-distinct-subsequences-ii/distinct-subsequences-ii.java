class Solution {
    int MOD = 1000000007; 
    public int distinctSubseqII(String s) {
        // at each point we check at the index how many subsequence 

        // 1 3  = 3 + 4 = 7
        // 1 2 2 + 1 = 1 2 3 = 6 
        // 1 2 2 + 1 = 3 

        // keep track of the boolean array to check if the single is taken before if not taken +=2 else +=1 
        int n = s.length(); 
        long dp[] = new long[n]; 
        int check[] =new int[26]; 
        Arrays.fill(check , -1); 
        check[s.charAt(0)-'a'] = 0; 
        dp[0] = 1; 
        for(int i = 1 ; i < n ; i++){
            
            if(check[s.charAt(i)-'a'] != -1 ){
                int last = check[s.charAt(i)-'a'];
                long dups = 0; 
                if(last > 0 ) dups = dp[last-1]; 

                dp[i] = (1L * 2 * dp[i-1] % MOD - dups + MOD) % MOD; 
            }
            else{
                dp[i] = (1L * 2 * dp[i-1] + 1) % MOD; 
                
            }
            check[s.charAt(i)-'a'] = i; 
        }
        return (int)dp[n-1]; 
    }
}