class Solution {

    int ans = Integer.MAX_VALUE;
    int k;
    int n;

    void f(int broken, int time, boolean[] used, List<Integer> strength) {

        if (broken == n) {
            ans = Math.min(ans, time);
            return;
        }

        int x = 1 + broken * k;

        for (int i = 0; i < n; i++) {

            if (used[i])
                continue;

            used[i] = true;

            int minutes = (strength.get(i) + x - 1) / x; // ceil

            f(
                    broken + 1,
                    time + minutes,
                    used,
                    strength);

            used[i] = false;
        }
    }

    public int findMinimumTime(List<Integer> strength, int k) {

        this.k = k;
        this.n = strength.size();

        boolean[] used = new boolean[n];

        f(0, 0, used, strength);

        return ans;
    }
}