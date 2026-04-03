class Solution {
    int MOD = 1000000007;
    int[][] dp;

    public int f(int c, int t){
        if(t == 0) return 1;

        if(dp[c][t] != -1) return dp[c][t];

        int res;

        if(c == 25){ // 'z'
            res = (f(0, t-1) + f(1, t-1)) % MOD;
        } else {
            res = f(c+1, t-1) % MOD;
        }

        return dp[c][t] = res;
    }

    public int lengthAfterTransformations(String s, int t) {
        dp = new int[26][t+1];

        for(int i = 0; i < 26; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for(char ch : s.toCharArray()){
            ans = (ans + f(ch - 'a', t)) % MOD;
        }

        return ans;
    }
}