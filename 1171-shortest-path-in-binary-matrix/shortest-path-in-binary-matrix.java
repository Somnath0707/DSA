class Triple{
    int distance;
    int row ; 
    int col ;

    Triple (int d , int r , int c ) {
        this.distance = d ; 
        this.row = r; 
        this.col = c;
    }
}


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1 ) return -1 ;
        // check if src and dst are same 
        Queue<Triple> q = new LinkedList<>();

        int n = grid.length ; 
        int m = grid[0].length;

        int[][] distance = new int[n][m];

        for(int i = 0; i< n ; i++){
            Arrays.fill(distance[i] , Integer.MAX_VALUE);
        }

        distance[0][0] = 0 ; 

        q.add(new Triple ( 0 , 0 , 0 ));
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};


        while(!q.isEmpty()){
            Triple curr = q.poll();
            int dis = curr.distance; 
            int r = curr.row; 
            int c = curr.col;

            for(int i = 0; i< 8 ; i++){
                int newRow = r + dr[i];
                int newCol = c + dc[i];


                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && dis + 1 < distance[newRow][newCol]){
                    distance[newRow][newCol] = 1 + dis;
                    q.add(new Triple(distance[newRow][newCol] , newRow , newCol));
                }
            }
        }

        for(int i = 0 ; i < distance.length ; i++){
            for(int j = 0; j < distance[0].length ; j++){
                if(distance[i][j] == Integer.MAX_VALUE){
                    distance[i][j] = -1 ; 
                }
            }
        }
        if(distance[m-1][n-1] == -1 ) return -1 ; 
        return distance[m-1][n-1] + 1 ;
    }
}