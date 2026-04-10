class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // time, row, col

        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == m-1){
                return time;
            }

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int nextTime = Math.max(time , moveTime[nr][nc]) + 1;

                    if(nextTime < dist[nr][nc]){
                        dist[nr][nc] = nextTime;
                        pq.offer(new int[]{nextTime, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}