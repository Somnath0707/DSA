class RollingHash {
    long pow[];
    long hash[];
    long base = 31;
    long MOD = 1000000007;

    RollingHash(String s) {
        int n = s.length();
        pow = new long[n + 1];
        hash = new long[n];

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * base) % MOD;
        }

        hash[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            hash[i] = (hash[i - 1] * base + (s.charAt(i) - 'a' + 1)) % MOD;
        }
    }

    long getHash(int l, int r) {
        if (l == 0)
            return hash[r];

        long ans = (hash[r] - hash[l - 1] * pow[r - l + 1]) % MOD;

        if (ans < 0)
            ans += MOD;
        return ans;
    }
}

class Solution {
    public int longestDecomposition(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        RollingHash re = new RollingHash(s);
        int ans = 0;

        while (left <= right) {
            // int i = left ; 
            // int j = right ; 
            boolean found = false;
            for (int i = left; i <= right; i++) {
                int len = i - left + 1;
                int leftLen = right - len + 1;
                if (re.getHash(left, i) == re.getHash(leftLen, right)) {
                    // ans+=2;
                    if (left == leftLen) {
                        // The prefix and suffix are actually the SAME substring.
                        ans += 1;
                    } else {
                        ans += 2;
                    }
                    len = i - left + 1;
                    right = right - len;
                    left = i + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans += 1;
                break;
            }
        }

        return ans;
    }
}
