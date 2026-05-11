class Solution {
    public int bfs(int j , int [] currBomb , int[][] bombs){
        Queue<int[]> q = new LinkedList<>();
        int n = bombs.length;

        q.offer(currBomb);
        boolean vis[] = new boolean[n];
        vis[j] = true; 
        int count = 1; 
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int x1 = curr[0];
            int y1 = curr[1];
            int r1 = curr[2];
            for(int i = 0 ; i < n ; i++){
                int x2 = bombs[i][0];
                int y2 = bombs[i][1];
                if(!vis[i]){
                    long X = x1-x2;
                    long Y = y1 - y2;

                    long check = X*X + Y*Y;
                    if(check <= 1L * r1 * r1){
                        count++;
                        vis[i] = true; 
                        q.offer(bombs[i]);
                    }
                }
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length ;
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans ,bfs(i , bombs[i] , bombs));
        }

        return ans ; 
    }
}