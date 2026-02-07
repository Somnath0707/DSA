class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    // BFS to mark all connected '1's starting from (row, col)
    public void bfs(int row, int col, int[][] vis, char[][] grid) {

        // Step 1: mark starting cell as visited
        vis[row][col] = 1;

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        /*
         * EXAMPLE:
         * grid = 
         * 1 1 0
         * 0 1 0
         * 0 0 1
         *
         * Start BFS at (0,0):
         * - mark (0,0) visited
         * - push to queue → [(0,0)]
         *
         * Process neighbours (only 4-direction):
         * (0,1) is '1' → visit
         * (1,0) is '0' → ignore
         *
         * Queue becomes [(0,1)]
         */

        while (!q.isEmpty()) {

            // Step 2: take current cell
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            // Step 3: explore 4-direction neighbors
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {

                    // Skip diagonals — only UP/DOWN/LEFT/RIGHT allowed
                    if (Math.abs(delRow) + Math.abs(delCol) != 1) continue;

                    int nrow = ro + delRow;
                    int ncol = co + delCol;

                    // Step 4: check valid boundary + is '1' + unvisited
                    if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' &&
                        vis[nrow][ncol] == 0) {

                        // Step 5: mark visited
                        vis[nrow][ncol] = 1;

                        // Step 6: push new cell to BFS queue
                        q.add(new Pair(nrow, ncol));

                        /*
                         * Example continuation:
                         * From (0,1):
                         *   Down → (1,1) = '1' → mark visited
                         *   Others ignore
                         *
                         * Queue → [(1,1)]
                         */
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int cnt = 0;

        /*
         * EXAMPLE WALKTHROUGH for grid:
         *
         * 1 1 0
         * 0 1 0
         * 0 0 1
         *
         * Loop over all cells:
         * (0,0) → '1' & not visited → NEW ISLAND → BFS→ marks whole island
         * (0,1) → already visited → skip
         * (1,1) → already visited → skip
         * (2,2) → '1' & not visited → NEW ISLAND
         *
         * Total islands = 2
         */

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                // Found a new unvisited island → launch BFS
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;                   // increase island count
                    bfs(row, col, vis, grid); // mark entire island
                }
            }
        }
        return cnt;
    }
}
