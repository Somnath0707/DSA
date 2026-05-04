class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Augmented string
        StringBuilder str = new StringBuilder();
        str.append('1').append(s).append('1');
        int m = str.length();

        // Prefix/Suffix arrays
        int[] prefixZ = new int[m];
        int[] suffixZ = new int[m];
            // int[] prefixO = new int[m];
        int[] suffixO = new int[m];

        // Build prefix arrays on t
        for (int i = 0; i < m; i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                prefixZ[i] = (i > 0 ? prefixZ[i - 1] : 0) + 1;
                // prefixO[i] = 0;
            } else {
                // prefixO[i] = (i > 0 ? prefixO[i - 1] : 0) + 1;
                prefixZ[i] = 0;
            }
        }

        // Build suffix arrays on t
        for (int i = m - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '0') {
                suffixZ[i] = (i + 1 < m ? suffixZ[i + 1] : 0) + 1;
                suffixO[i] = 0;
            } else {
                suffixO[i] = (i + 1 < m ? suffixO[i + 1] : 0) + 1;
                suffixZ[i] = 0;
            }
        }

        // Base answer = existing number of '1's in original s
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }

        int ans = ones;

        // Check every 1-block in t
        for (int i = 1; i < m - 1; i++) {
            // start of a 1-block (left char is 0)
            if (str.charAt(i) == '1' && str.charAt(i - 1) == '0') {
                int lenOneBlock = suffixO[i];   // length of this 1-block
                int rightIndex = i + lenOneBlock;

                // must have 0 on the right side too
                if (rightIndex < m && str.charAt(rightIndex) == '0') {
                    int leftZero = prefixZ[i - 1];
                    int rightZero = suffixZ[rightIndex];

                    // net gain = left zero block + right zero block
                    ans = Math.max(ans, ones + leftZero + rightZero);
                }
            }
        }

        return ans;
    }
}