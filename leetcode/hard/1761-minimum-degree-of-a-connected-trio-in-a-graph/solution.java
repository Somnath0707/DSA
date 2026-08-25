class Solution {

    public int minTrioDegree(int n, int[][] edges) {

        List<Set<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new HashSet<>());
        }

        int[] degree = new int[n + 1];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        int ans = Integer.MAX_VALUE;

        // Pick the first node
        for (int i = 1; i <= n; i++) {

            // Go through all nodes directly connected to i
            for (int j : adj.get(i)) {

                // Avoid checking the same pair in the other order
                if (j <= i) continue;

                // Check nodes connected to both i and j
                for (int k : adj.get(j)) {

                    if (k <= j) continue;

                    if (adj.get(i).contains(k)) {

                        int trioDegree =
                                degree[i] +
                                degree[j] +
                                degree[k] - 6;

                        ans = Math.min(ans, trioDegree);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}