class Solution {
    public int [] f(int n , List<List<Integer>> adj , int curr){
        int d[] = new int [n];
        Arrays.fill(d , -1);
        Queue<Integer > q=  new LinkedList<>();

        q.offer(curr);
        d[curr] = 0 ; 

        while(!q.isEmpty()){
            int no = q.poll();
            for(int ite : adj.get(no)){
                if(d[ite] == -1 ){
                    d[ite] = d[no] + 1 ;
                    q.offer(ite);
                }
            }
        }
        return d;
    }
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int dx[] = f(n , adj , x);
        int dy[] = f(n , adj , y);
        int dz[] = f(n , adj , z);

        int count = 0; 
        for(int i = 0 ; i < n ; i++){
            int a = dx[i] , b = dy[i] , c = dz[i];
            int temp[] = {a , b , c };
            Arrays.sort(temp);

            int d1 = temp[0] * temp[0];
            int d2 = temp[1] * temp[1];
            int d3 = temp[2] * temp[2];

            if(d1 + d2 == d3){
                count ++;
            }
        }
    return count ;
    }
}