class Solution {
    int MOD = 1000000007; 
    Integer dp[]; 
    public int f(int i, String s) {
        if (i >= s.length() )
            return 1;

        if(dp[i] != null) return dp[i]; 
        int take = 0;
        int n = s.length(); 
        if (s.charAt(i) != '7' && s.charAt(i) != '9') {
            for (int ind = 1; ind <= 2; ind++) {
                if (i + ind >= n)
                    break;
                if (s.charAt(i) == s.charAt(i + ind)) {
                    take = (take + f(i+ind+1, s)) % MOD ;
                }
                else break ; 
            }
        } else {
            for (int ind = 1; ind <= 3; ind++) {
                if (i + ind >= n)
                    break;
                if (s.charAt(i) == s.charAt(ind + i)) {
                    take = (take + f(ind + i + 1, s)) % MOD ;
                }else {
                    break; 
                }
            }
        }

        take = (take + f(i + 1, s)) % MOD;

        return dp[i]=  take;

    }

    public int countTexts(String s) {
        // from 2 to 8 ew can do is 3 and for 7 and 9 we can click 4 times 
        // 6 * 36-3 =
        dp = new Integer[s.length()] ;
        return f(0, s);
    }
}