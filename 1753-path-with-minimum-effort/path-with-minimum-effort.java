class Triple {
    int diff; 
    int row ; 
    int col ; 

    Triple(int dif , int r , int c){
        this.diff = dif;
        this.row = r;
        this.col = c ; 
    }
}


class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Triple> pq = new PriorityQueue<>((x, y ) -> x.diff - y.diff );

        int n = heights.length ;
        int m = heights[0].length ; 

        int [][]distance = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(distance[i] , Integer.MAX_VALUE);
        }

        distance[0][0] = 0 ; 

        pq.add(new Triple(0 , 0 , 0 ));

        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1 , 0 , -1};

        while(!pq.isEmpty()){
            Triple curr = pq.poll();
            int dif = curr.diff;
            int r = curr.row; 
            int c = curr.col;

            for(int i = 0 ;  i < 4 ; i++){
                int newRow = r + dr[i]; 
                int newCol = c + dc[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m ){
                    int edgeDiff = Math.abs(heights[newRow][newCol] - heights[r][c]);

                    int newEffort = Math.max(dif , edgeDiff);

                    if(distance[newRow][newCol] > newEffort){
                        distance[newRow][newCol] = newEffort;
                        pq.add(new Triple(newEffort , newRow , newCol));
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}