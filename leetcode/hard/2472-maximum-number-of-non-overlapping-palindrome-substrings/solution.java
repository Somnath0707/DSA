class Solution {
    boolean isPal[][]; 
    Integer dp[]; 
    public int f(int i, String s, int k) {
        if (i == s.length())
            return 0;
        if(dp[i] != null) return dp[i];
        int ans = 0;
        ans = f(i + 1, s, k);

        for (int ind = i; ind < s.length(); ind++) {
            if (ind - i + 1 >= k && isPal[i][ind]) {
                ans = Math.max(1 + f(ind + 1, s, k), ans);
            }
        }

        return dp[i] = ans;
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length(); 
        isPal = new boolean[n][n]; 
        dp = new Integer[n]; 
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }
        return f(0, s, k);
    }
}