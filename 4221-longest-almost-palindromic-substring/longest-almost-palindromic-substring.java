class Solution {

    String s;
    int[][] dp0;
    int[][] dp1;

    static final int UNVISITED = Integer.MAX_VALUE;
    static final int BAD = -1000000000;

    public int f(int l, int r, int used) {

        if (l > r) return 0;
        if (l == r) return 1;

        if (used == 0) {
            if (dp0[l][r] != UNVISITED)
                return dp0[l][r];
        } else {
            if (dp1[l][r] != UNVISITED)
                return dp1[l][r];
        }

        int ans;

        if (s.charAt(l) == s.charAt(r)) {

            ans = 2 + f(l + 1, r - 1, used);

        } else {

            if (used == 1) {
                return dp1[l][r] = BAD;
            }

            int a = f(l + 1, r, 1);
            int b = f(l, r - 1, 1);

            ans = 1 + Math.max(a, b);
        }

        if (used == 0)
            dp0[l][r] = ans;
        else
            dp1[l][r] = ans;

        return ans;
    }

    public int almostPalindromic(String s) {

        this.s = s;

        int n = s.length();

        dp0 = new int[n][n];
        dp1 = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp0[i], UNVISITED);
            Arrays.fill(dp1[i], UNVISITED);
        }

        int best = 0;

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {

                int cur = f(l, r, 0);

                if (cur != BAD)
                    best = Math.max(best, cur);
            }
        }

        return best;
    }
}