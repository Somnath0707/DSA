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
        // cant i use bitmask dp here

        // or trie 

        // the trie could be we generrate a trie for in for loop and try to check with for loop + 1 till the lenth of that currnet trie; 

        // ex : abcabcabc for trie 1 a then we move to for loop i+1 b not match ab next not abc i+1 abc ok we found once we only have to go thill the n/2 abca no abcba no stop so now start from b 
        // the time complexity would be n^2 log n most probably checking all substring but the trie check is direct so may be or I could be wrong 
        RolllingHash re = new RolllingHash(text);

        int ans = 0;
        int n = text.length();
        Set<String> set = new HashSet<>();
        // Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int left = i;
                int right = j;
                if (j - i + 1 > n - j - 1)
                    break;
                int newLeft = j + 1;
                int newRight = newLeft + (j - i);
               

                String tempLeft = text.substring(left , right+1); 
                if(set.contains(tempLeft))continue; 
                String tempRight = text.substring(newLeft , newRight+1); 
                if(tempLeft.equals(tempRight)){
                    ans++; 
                    set.add(tempLeft);
                }
                

            }
        }
        return ans;
    }
}