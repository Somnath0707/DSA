public class DSU {
    private final int[] parent;
    private final int[] rank;
    public int count;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    public boolean union(int i, int j) {
        int rootI = find(i), rootJ = find(j);
        if (rootI == rootJ) return false;
        if (rank[rootI] < rank[rootJ]) { int t = rootI; rootI = rootJ; rootJ = t; }
        parent[rootJ] = rootI;
        if (rank[rootI] == rank[rootJ]) rank[rootI]++;
        count--;
        return true;
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        // so I just form a connected components and count them and n - total components now the important thing is from corditane the component can be forment if there is matching row or coloumn so 

        // that is any one with row zero gets goined to the group of zero but now the other coonected can alo join if they have same column 

        // so we can do is create a. hash table with the thing like if we see the stuff is connected to our row or column then it gets added to it if non 
        Map<Integer,Integer> row = new HashMap<>();
        Map<Integer,Integer> col = new HashMap<>(); 
        int n = stones.length; 
        DSU dsu = new DSU(n); 
        for(int i = 0 ;i < stones.length; i++){
            int x = stones[i][0]; 
            int y = stones[i][1]; 

            if(row.containsKey(x)){
                dsu.union(i , row.get(x));
            }
            row.put(x , i );

            if(col.containsKey(y)){
                dsu.union(i, col.get(y));
            }
            col.put(y ,i); 
        }

        int total = dsu.count;
        System.out.println(total); 
        return n-total; 


    }
}