class Solution {
    public boolean findSafeWalk(List<List<Integer>> list, int health) {
        // if the health become 0 return false
        // if we reach final with health > 0 return true; 

        int [][] nums = new int[list.size()][list.get(0).size()];
        int n = nums.length; 
        int m = nums[0].length;

        for(int i = 0; i < list.size() ; i++){
            for(int j = 0 ; j < list.get(0).size() ; j++){
                nums[i][j] = list.get(i).get(j);
            }
        }
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int temp = nums[0][0];
        
        pq.offer(new int[]{temp , 0 , 0 });

        int dir[][] = {
                        {-1 , 0},// up 
                        {0 , 1 },// right
                        {1 , 0 },// down 
                        {0 , -1}// left
                        };


        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int cost = curr[0];
            int row = curr[1]; 
            int col = curr[2];

            if(row == n-1 && col == m-1 && cost < health) return true;

            if(cost >= health)  continue; 

            for(int d[] : dir){
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr < n && nr >= 0 && nc < m && nc >= 0 && !vis[nr][nc]){
                   int newCost = cost + nums[nr][nc];
                    vis[nr][nc] = true;
                    pq.offer(new int[]{newCost , nr , nc});
                }
            }
        }

        return false;
    }
}