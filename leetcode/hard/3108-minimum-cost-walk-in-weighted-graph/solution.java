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
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n); 

        for(int i = 0 ; i < edges.length ; i++){
            dsu.union(edges[i][0] , edges[i][1]);
        }

        Map<Integer,Integer> map = new HashMap<>(); 

        for(int i = 0 ; i < edges.length ; i++){
            int curr = edges[i][0]; 
            int parent = dsu.find(curr); 
            int val = edges[i][2]; 
            if(map.containsKey(parent)){
                int newAnd = val & map.get(parent); 
                map.put(parent , newAnd);
            }
            else{
                map.put(parent , val); 
            }
        }   

        int ans[] = new int[query.length];

        for(int i = 0 ; i < query.length ; i++){
            int u = query[i][0]; 
            int v = query[i][1]; 

            if(dsu.find(u) != dsu.find(v)){
                ans[i] = -1; 
            }else{
                ans[i] = map.get(dsu.find(u));
            }
        }

        return ans; 
    }
}