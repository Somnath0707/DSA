class Solution {
    long f(int i, int tight, String s , long dp[][]) {
        if (i == s.length()) return 1;

        int limit = (tight == 1) ? s.charAt(i) - '0' : 9;
        long count = 0;
        if(dp[i][tight] != -1 ) return dp[i][tight];

        for (int d = 1; d <= 9; d++) {
            if (d > limit) break;

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            count += f(i + 1, nextTight, s , dp);
        }

        return dp[i][tight] = count;
    }

    public long countDistinct(long n) {
        String s = String.valueOf(n);
        long dp[][] = new long[20][2];
        for(int i = 0 ; i < 20 ; i++){
            Arrays.fill(dp[i] , -1 );
        }
        long len = s.length();
        
        long ans = 0;

        // count numbers with smaller length
        for (int l = 1; l < len; l++) {
            ans += Math.pow(9, l);
        }

        // count same length
        ans += f(0, 1, s , dp);

        return ans;
    }

    
}