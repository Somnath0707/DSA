class RollingHash {
    long[] pow;
    long[] hash;
    long base = 6767;
    long MOD = 1000000007L;

    RollingHash(String s) {
        int n = s.length();

        pow = new long[n + 1];
        hash = new long[n + 1];

        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * base) % MOD;
        }

        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * base + s.charAt(i)) % MOD;
        }
    }

    long getHash(int l, int r) {
        long ans = hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD;
        if (ans < 0) ans += MOD;
        return ans;
    }
}

class Solution {

    RollingHash rh;

    boolean check(int first, int second, String s) {

        int n = s.length();

        int len = Math.min(n - first, n - second);

        int low = 0;
        int high = len;

        // Longest Common Prefix
        while (low < high) {
            int mid = (low + high + 1) / 2;

            if (rh.getHash(first, first + mid - 1) ==
                rh.getHash(second, second + mid - 1)) {

                low = mid;
            } else {
                high = mid - 1;
            }
        }

        int lcp = low;

        if (lcp == len) {
            return (n - first) < (n - second);
        }

        return s.charAt(first + lcp) < s.charAt(second + lcp);
    }

    public String lastSubstring(String s) {

        rh = new RollingHash(s);

        char prev = '<';
        int max = -1;

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch > prev) {
                prev = ch;
                max = i;
            } else if (ch == prev) {

                if (!check(i, max, s)) {
                    max = i;
                }
            }
        }

        return s.substring(max);
    }
}