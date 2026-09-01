class Solution {
    public int minMoves(String[] s, int energy) {
        // so we have to remove all the litter ok

        // In minimum steps 
        // How will we know how much litter collected and how much left best way is to first count all the litter in the grid and then if during bfs at any point we get same number of litter we get the answer 

        // bfs we will need row , col , energy , litter , steps 
        // and what ? may be thats it I guess, this could be our one state so vis could be this set

        int firstRow = 0, firstCol = 0;
        int n = s.length;
        int m = s[0].length();
        int count = 0;

        // to know which litter has which bit
        int[][] litterId = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(litterId[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == 'S') {
                    firstRow = i;
                    firstCol = j;
                }
                else if (s[i].charAt(j) == 'L') {
                    litterId[i][j] = count;
                    count++;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        // row , col , energy , litter , steps
        // litter is now mask
        q.offer(new int[]{firstRow, firstCol, energy, 0, 0});

        // Set<String> set = new HashSet<>();

        // String key = firstRow + "#" + firstCol + "#" + energy + "#" + 0;
        // set.add(key);

        boolean vis[][][][] = new boolean[n][m][energy + 1][1 << count];

        vis[firstRow][firstCol][energy][0] = true; 

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, -1},
            {0, 1}
        };

        int allLitter = (1 << count) - 1;

        while (!q.isEmpty()) {
            int curr[] = q.poll();

            int row = curr[0];
            int col = curr[1];
            int currEng = curr[2];
            int litter = curr[3];
            int steps = curr[4];

            if (litter == allLitter) return steps;

            for (int d[] : dir) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    s[nr].charAt(nc) != 'X') {

                    if (currEng < 1) continue;

                    char ch = s[nr].charAt(nc);

                    int newEng = currEng - 1;
                    int newLitter = litter;

                    if (ch == 'R') {
                        newEng = energy;
                    }

                    if (ch == 'L') {
                        int id = litterId[nr][nc];
                        newLitter = litter | (1 << id);
                    }

                    // String temp = nr + "#" + nc + "#" + newEng + "#" + newLitter;

                    // if (set.contains(temp)) continue;

                    if(vis[nr][nc][newEng][newLitter]) continue; 

                    q.offer(new int[]{
                        nr, nc, newEng, newLitter, steps + 1
                    });

                    vis[nr][nc][newEng][newLitter] = true; 
                }
            }
        }

        return -1;
    }
}