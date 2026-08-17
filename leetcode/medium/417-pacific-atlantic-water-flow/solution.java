class Solution {

    boolean[][] pacCheck; 
    boolean atlCheck[][]; 
    int dir[][] = {
        {1 , 0} , {0 , 1} , {-1 , 0} , {0 , -1}
    };
    int n ; 
    int m ; 
    public void bfs(int[][] nums , Queue<int[]> q , int check ){
        boolean vis[][] = new boolean[n][m]; 

        while(!q.isEmpty()){
            int curr[] = q.poll(); 

            int row = curr[0]; 
            int col = curr[1];
            int prevHeight = nums[row][col];  

            for(int d[]: dir){
                int nr = row + d[0]; 
                int nc = col + d[1]; 

                if(nr >= 0 && nr < n && nc < m && nc >= 0 && vis[nr][nc] == false ){
                    int currHeight = nums[nr][nc]; 
                    if(currHeight >= prevHeight){
                        vis[nr][nc] = true; 
                        if(check == 1){
                            atlCheck[nr][nc] = true; 
                        }else{
                            pacCheck[nr][nc] = true; 
                        }

                        q.offer(new int[]{nr , nc});
                    }
                    else{
                        continue; 
                    }
                }
            }
        }
        return ; 
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // simple way is to just to check for each if they go to left most and rightmost or upper and lower or left and down or upp and right
        n = heights.length ; 
        m = heights[0].length ;  
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();  
        pacCheck = new boolean[n][m]; 
        atlCheck = new boolean[n][m]; 

        

        for(int i = 0 ; i < n ; i++){
            pacific.offer(new int[]{i , 0});
            pacCheck[i][0] = true; 
            atlantic.offer(new int[]{i , m-1});
            atlCheck[i][m-1]=true; 
        }

        for(int i = 0 ; i < m ; i++){
            pacific.offer(new int[]{0 , i});
            pacCheck[0][i] = true; 
            atlantic.offer(new int[]{n-1 , i});
            atlCheck[n-1][i] = true; 
        }

        bfs(heights , atlantic , 1); 
        bfs(heights , pacific , 0 ); 
        List<List<Integer>> ans = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(atlCheck[i][j] && pacCheck[i][j]){
                    ArrayList<Integer> list = new ArrayList<>(); 
                    list.add(i); 
                    list.add(j) ;
                    ans.add(list); 
                }
            }
        }


        return ans; 


    }
}