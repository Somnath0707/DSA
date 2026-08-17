class Solution {
    Map<Integer,Integer> map; 
    int n; 
    int m; 
    int nums[][] ; 
    boolean vis[][] ;
    public int bfs(int [][] grid , int tempI , int tempJ , boolean isZero , int id){
        Queue<int[]> q = new LinkedList<>(); 
        
        vis[tempI][tempJ] = true; 
        Set<Integer> set = new HashSet<>(); 
        int val = nums[tempI][tempJ] ;
        if(map.containsKey(val)) return map.get(val); 
        q.offer(new int[]{tempI , tempJ});

        int dir[][] = {
            {1, 0},
            {-1,0},
            {0,1},
            {0, -1}
        };

        int count = 1 ; 
        if(!isZero)
        nums[tempI][tempJ] = id ; 
        while(!q.isEmpty()){
            int curr[] = q.poll(); 
            int i = curr[0]; 
            int j = curr[1]; 

            for(int d[] : dir){
                int nr = i + d[0]; 
                int nc = j + d[1]; 

                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && (vis[nr][nc] == false || isZero) && grid[nr][nc] == 1){
                    if(nums[nr][nc] != -1){
                    if(!set.contains(nums[nr][nc])){
                        count += map.get(nums[nr][nc]); 
                        set.add(nums[nr][nc]);
                        continue;
                    }
                    else{
                        continue; 
                    }
                }
                    if(!isZero)
                    nums[nr][nc] = id; 
                    vis[nr][nc] = true; 
                    count++; 
                    q.offer(new int[]{nr , nc});
                }
            }

        }

        if(!isZero){
            map.put(id , count );
        }
        return count ; 
    }
    public int largestIsland(int[][] grid) {
        n = grid.length ; 
        m = grid[0].length ; 
        nums = new int[n][m]; 
        vis =  new boolean[n][m]; 
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(nums[i], -1);
        }
        map = new HashMap<>(); 
        int ans = 0 ; 
        int id = 2; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans , bfs( grid , i , j , false , id));
                    id++; 
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    ans = Math.max(ans , bfs(grid , i , j , true , -1));
                }

            }
        }
        return ans; 
    }
}