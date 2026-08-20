class Solution {
    public int longestSubsequence(String s, int k) {
        int countZero = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0')
                countZero++;
        }

        long val = 0;
        long power = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int ch = s.charAt(i) - '0';
            if (ch == 1) {
                if (val + power > k)
                    break;
                val += power;
                countZero++;
            }
            if(power <= k)
            power *= 2;
        }

        return countZero;
    }
}