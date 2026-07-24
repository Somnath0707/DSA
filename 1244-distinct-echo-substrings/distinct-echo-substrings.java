class RolllingHash {
    long MOD = 1000000007;
    long base = 31;

    long pow[];
    long hash[];

    RolllingHash(String s) {
        int n = s.length();

        pow = new long[n + 1];
        hash = new long[n];

        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * base) % MOD;
        }

        hash[0] = s.charAt(0) - 'a' + 1;

        for (int i = 1; i < n; i++) {
            hash[i] = ((hash[i - 1] * base) + (s.charAt(i) - 'a' + 1)) % MOD;
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

    public int distinctEchoSubstrings(String text) {

        Set<String> set = new HashSet<>();
        int n = text.length();

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int len = j - i + 1;

                if ((len & 1) == 1)
                    continue;

                int mid = i + len / 2;

                boolean same = true;

                for (int k = 0; k < len / 2; k++) {

                    if (text.charAt(i + k) != text.charAt(mid + k)) {
                        same = false;
                        break;
                    }
                }

                if (same)
                    set.add(text.substring(i, j + 1));
            }
        }

        return set.size();
    }
}