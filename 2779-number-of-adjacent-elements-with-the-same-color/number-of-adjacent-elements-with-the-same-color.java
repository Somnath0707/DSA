class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] color = new int[n];
        int[] ans = new int[queries.length];
        int count = 0;

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int c = queries[i][1];

            // remove old contribution
            if (color[idx] != 0) {
                if (idx > 0 && color[idx] == color[idx - 1]) count--;
                if (idx < n - 1 && color[idx] == color[idx + 1]) count--;
            }

            // paint new color
            color[idx] = c;

            // add new contribution
            if (idx > 0 && color[idx] == color[idx - 1]) count++;
            if (idx < n - 1 && color[idx] == color[idx + 1]) count++;

            ans[i] = count;
        }

        return ans;
    }
}