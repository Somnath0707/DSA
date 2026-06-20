class Solution {
    int n ; 
    int MOD = 1000000007;
    int dp[]; 
    public int f(int i  , String s , int k ){
        if(i >= s.length()){
            return 1 ; 
        }

        if(s.charAt(i) == '0') return 0 ; 
        if(dp[i] != -1 ) return dp[i]; 

        int ans = 0 ; 
        long num = 0 ; 
        for(int j = i ; j < n ; j++){
            int dig = s.charAt(j) - '0';
            num = num * 10 + dig;

            if(num <= k ){
                ans = (ans +  f(j+1 , s , k)) % MOD;
            }
            else break; 
        }
        return dp[i] =  ans;
    }
    public int numberOfArrays(String s, int k) {
    //  forgot to print white spaces 
    // array was printed as a string of digits s 
    // we only know that the integer in the array were in the range 1 to k and there were no leading zero in the array 

    // what i get is that this is like dp 
    // we cant take the leading zero 
    // 1002 and 10000 will be 100 and 2 not 10 02 or 1 002 or 1 00 2 
    // we can take take or skip but we cant skip if the curr char is 0 
    // i think we need i and len 
    // why len to get the substring and then convert them to the integer and cehck if the numbeer is the range duh 
    // so whenver we take skip we take subtring and check if we take we dont take substring 
    n = s.length();
    dp = new int[n+1]; 
    Arrays.fill(dp , - 1 );  
    return f(0 , s , k );
    }
}