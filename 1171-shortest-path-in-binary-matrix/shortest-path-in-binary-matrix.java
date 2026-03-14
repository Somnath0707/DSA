class Triple{
    int distance;
    int row;
    int col;

    Triple(int d,int r,int c){
        distance=d;
        row=r;
        col=c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<Triple> q = new LinkedList<>();

        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);

        dist[0][0]=1;

        q.add(new Triple(1,0,0));

        int[] dr={-1,-1,-1,0,0,1,1,1};
        int[] dc={-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){

            Triple curr=q.poll();

            int d=curr.distance;
            int r=curr.row;
            int c=curr.col;

            if(r==n-1 && c==n-1) return d;

            for(int i=0;i<8;i++){

                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0 && d+1<dist[nr][nc]){

                    dist[nr][nc]=d+1;
                    q.add(new Triple(d+1,nr,nc));
                }
            }
        }

        return -1;
    }
}