class Solution {
    Integer[][] dp;
    Integer[][] dpWays;
    int MOD = 1000000007;
    int NEG = -1000000000;

    public int f(int i, int j, char[][] graph) {
        if (i == 0 && j == 0)
            return 0;

        if (i < 0 || j < 0)
            return NEG;

        if (graph[i][j] == 'X')
            return NEG;

        if (dp[i][j] != null)
            return dp[i][j];

        int val = (graph[i][j] == 'S' || graph[i][j] == 'E') ? 0 : graph[i][j] - '0';

        int up = f(i - 1, j, graph);
        int left = f(i, j - 1, graph);
        int diag = f(i - 1, j - 1, graph);

        int best = Math.max(up, Math.max(left, diag));

        if (best == NEG)
            return dp[i][j] = NEG;

        return dp[i][j] = val + best;
    }

    public int ways(int i, int j, char[][] graph) {
        if (i < 0 || j < 0)
            return 0;

        if (graph[i][j] == 'X')
            return 0;

        if (i == 0 && j == 0)
            return 1;

        if (dpWays[i][j] != null)
            return dpWays[i][j];

        int val = (graph[i][j] == 'S' || graph[i][j] == 'E') ? 0 : graph[i][j] - '0';

        int best = f(i, j, graph);

        long ans = 0;

        int up = f(i - 1, j, graph);
        int left = f(i, j - 1, graph);
        int diag = f(i - 1, j - 1, graph);

        if (up != NEG && up + val == best)
            ans = (ans + ways(i - 1, j, graph)) % MOD;

        if (left != NEG && left + val == best)
            ans = (ans + ways(i, j - 1, graph)) % MOD;

        if (diag != NEG && diag + val == best)
            ans = (ans + ways(i - 1, j - 1, graph)) % MOD;

        return dpWays[i][j] = (int) ans;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        char[][] graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = board.get(i).charAt(j);
            }
        }

        dp = new Integer[n][n];
        dpWays = new Integer[n][n];

        int maxScore = f(n - 1, n - 1, graph);

        if (maxScore < 0)
            return new int[] { 0, 0 };

        int cnt = ways(n - 1, n - 1, graph);

        return new int[] { maxScore, cnt };
    }
}