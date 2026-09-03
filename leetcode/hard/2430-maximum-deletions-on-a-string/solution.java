class RollingHash {
    long MOD = 1_000_000_007L;
    long BASE = 911382323L;

    long[] hash;
    long[] power;

    RollingHash(String s) {
        int n = s.length();

        hash = new long[n + 1];
        power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * BASE + s.charAt(i)) % MOD;
            power[i + 1] = (power[i] * BASE) % MOD;
        }
    }

    // hash of s[l ... r-1]
    long getHash(int l, int r) {
        return (hash[r] - hash[l] * power[r - l] % MOD + MOD) % MOD;
    }
}

class Solution {
    RollingHash rh;
    Integer dp[][]; 

    public int f(int i, int start, String s) {
        if (i == s.length()) {
            return 1;
        }
        if(dp[i][start] != null) return dp[i][start]; 
        int take = 0;
        int skip = 0;
        int diff = i - start;
        if (diff > 0) {
            int next = i + diff;

            if (next <= s.length() &&
                    rh.getHash(start, i) == rh.getHash(i, next)) {

                take = 1 + f(i, i, s);
            }
        }

        skip = f(i + 1, start, s);

        return dp[i][start] =  Math.max(take, skip);
    }

    public int deleteString(String s) {
        // at each point we have two option either we could delete the entire string or we can check if curr 0 to i == i + 0+i

        // so I am staright away thing of using the rolling hash to match the curr len == next if match we have either two option extend it or count and move forward we need the minimum number of opertation I need to under if I have under stod the question 

        // why each option first we need in range changes  0 to i and then i + len to check which is best done using the rolling hash right 
        // after this each point I cnat just greedily take or I can taking small beifites but sometimes the may not 

        // at each point I have few option if match we can do is delete the string and move forward with new start as the i if not then we can continue or we can delete the enitre string 
        
        int n = s.length();
        dp = new Integer[n][n]; 
        rh = new RollingHash(s);

        return f(0, 0, s);

    }
}