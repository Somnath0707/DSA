class Solution {
    public int bfs(int j , int [] curr , int bombs[][]){
        int n = bombs.length;
        Queue<int[]> q = new LinkedList<>();

        q.offer(curr);
        boolean vis[] = new boolean[n];
        vis[j] = true;
        int count = 1 ; 
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x1 = temp[0]; 
            int y1 = temp[1];
            int r1 = temp[2];
            for(int i = 0 ; i < n ; i++){
                // check if not vis and also within th explosion range of the curr
                int x2 = bombs[i][0];
                int y2 = bombs[i][1];
                int r2 = bombs[i][2];

                if(!vis[i]){
                    long X = (long)x1 - x2;
                    long Y =(long)y1 - y2;

                    long check = 1L * X*X + Y*Y;
                    if(check <= 1L * r1*r1){
                        q.offer(bombs[i]);
                        vis[i] = true;
                        count++; 
                    }
                } 
            }
        }
        return count; 
    }
    public int maximumDetonation(int[][] bombs) {
        // take the bomb an detonate it 
        // we get the new range for acircle 
        // check if there are pair that can detonate within this range try to do it if so detnoate it and try to do like bfs denote the other too and do this for each bomb and get the max number of bomb we can detonate 

        // detonate one then do bfs all the detonatebal add them to queue then detonate that one and do bfs again but keep the vis track 
        // do it again till the queueis empty and keep the track all the poll ones 
        
        // use for loop to go through all the bombs 
        /// Complexity would be 0n2
        int ans = 0 ; 
        for(int i = 0 ; i < bombs.length ; i++){
            ans = Math.max(ans , bfs(i , bombs[i] , bombs));
        }

        return ans;
    }
}