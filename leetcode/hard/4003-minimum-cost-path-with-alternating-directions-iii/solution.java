class Solution {
    public long minCost(int n, int m, int[][] penalty) {
        // feels like bfs 
        // we need to reach n-1,m-1

        // we have at each point we have few option if parity do that operation with cost if no parity we again have two option get penelty + cost and move or 2 * cost and move 

        // visisted state should be like i j and parity 
        // it would be 0 and 1 and as the move number who cares about the move mumber that would just explode the state we just need 1 or 0

        // if we do bfs the visted would be [i][j][parity] if we do dijkstra we will have [i][j][parity] -> cost 

        // dijkstra is more fun as always 
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[3], b[3]));

        long cost[][][] = new long[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(cost[i][j], Long.MAX_VALUE);
            }
        }

        long ans = Long.MAX_VALUE;

        // even first is always even 
        cost[0][0][1] = 1;

        // if we try to force even after the next too 
        cost[0][0][0] = 1 + penalty[0][0];

        // the next parity will be 1 so we put one i , j , parity , cost
        pq.offer(new long[] { 0, 0, 1, 1 });

        // put both even and odd parity in 
        pq.offer(new long[] { 0, 0, 0, cost[0][0][0] });

        int dir[][] = {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };

        while (!pq.isEmpty()) {
            long curr[] = pq.poll();

            int row = (int) curr[0];
            int col = (int) curr[1];
            int parity = (int) curr[2];
            long currCost = curr[3];

            if (currCost > cost[row][col][parity])
                continue;

            if (row == n - 1 && col == m - 1) {
                return currCost;
            }

            // stay and change the parity
            int waitParity = (parity == 0) ? 1 : 0;
            long costPen = currCost + penalty[row][col];

            if (costPen < cost[row][col][waitParity]) {
                cost[row][col][waitParity] = costPen;
                pq.offer(new long[] { row, col, waitParity, costPen });
            }

            for (int d[] : dir) {
                long newCost = cost[row][col][parity];

                int nr = 0;
                int nc = 0;

                if (parity == 0) {
                    // if even parity and up and left usual 
                    if ((d[0] == -1 && d[1] == 0) ||
                            (d[0] == 0 && d[1] == -1)) {

                        nr = row + d[0];
                        nc = col + d[1];

                        newCost = currCost + ((long) (nr + 1) * (nc + 1));

                    } else {
                        // if even parity and right and down 
                        nr = row + d[0];
                        nc = col + d[1];

                        newCost = penalty[row][col]
                                + currCost
                                + ((long) (nr + 1) * (nc + 1));
                    }

                } else {

                    // if odd parity and up and left 
                    if ((d[0] == -1 && d[1] == 0) ||
                            (d[0] == 0 && d[1] == -1)) {

                        nr = row + d[0];
                        nc = col + d[1];

                        newCost = currCost
                                + penalty[row][col]
                                + ((long) (nr + 1) * (nc + 1));

                    } else {
                        // if odd parity and down and right usual 
                        nr = row + d[0];
                        nc = col + d[1];

                        newCost = currCost
                                + ((long) (nr + 1) * (nc + 1));
                    }
                }

                if (nr >= 0 && nc < m && nc >= 0 && nr < n) {
                    int newParity = (parity == 0) ? 1 : 0;

                    // move ahead 
                    if (newCost < cost[nr][nc][newParity]) {
                        pq.offer(new long[] { nr, nc, newParity, newCost });

                        cost[nr][nc][newParity] = Math.min(cost[nr][nc][newParity], newCost);
                    }

                }
            }
        }

        return ans;
    }
}