class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int we = edges[i][2];

            // {dest, weight, reversed, used}
            list.get(u).add(new int[]{v, we, 0, 0});

            list.get(v).add(new int[]{u, we * 2, 1, 0});
        }

        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[0] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{0, 0, 0, 0});

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            int u = curr[0];
            int we = curr[1];
            int rev = curr[2];
            int used = curr[3];

            for (int num[] : list.get(u)) {
                int next = num[0];
                int newWE = num[1];
                int newRev = num[2];
                int newUsed = num[3]; // nums -> num

                int newDis = we + newWE;

                if (newDis < dis[next]) {
                    dis[next] = newDis;

                    pq.offer(new int[]{next, newDis, newRev, newUsed});
                }
            }
        }

        return dis[n - 1] == Integer.MAX_VALUE ? -1 : dis[n - 1];
    }
}