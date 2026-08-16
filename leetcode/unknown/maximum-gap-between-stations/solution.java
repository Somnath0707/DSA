class Solution {

    public boolean check(int val, String skill, String s) {

        int n = skill.length();
        int m = s.length();

        int[] earliest = new int[n];

        int j = 0;

        for (int i = 0; i < n; i++) {

            while (j < m && s.charAt(j) != skill.charAt(i)) {
                j++;
            }

            if (j == m)
                return false;

            earliest[i] = j;
            j++;
        }


        int[] latest = new int[n];

        j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (j >= 0 && s.charAt(j) != skill.charAt(i)) {
                j--;
            }

            if (j < 0)
                return false;

            latest[i] = j;
            j--;
        }

        for (int i = 0; i < n - 1; i++) {

            if (latest[i + 1] - earliest[i] >= val) {
                return true;
            }
        }

        return false;
    }

    public int maximumGap(String skill, String station) {

        int left = 1;
        int right = station.length() - 1;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(mid, skill, station)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}