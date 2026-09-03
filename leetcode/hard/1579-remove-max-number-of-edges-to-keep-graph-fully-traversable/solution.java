public class DSU {
    private final int[] parent;
    private final int[] rank;
    public int count;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    public boolean union(int i, int j) {
        int rootI = find(i), rootJ = find(j);
        if (rootI == rootJ)
            return false;
        if (rank[rootI] < rank[rootJ]) {
            int t = rootI;
            rootI = rootJ;
            rootJ = t;
        }
        parent[rootJ] = rootI;
        if (rank[rootI] == rank[rootJ])
            rank[rootI]++;
        count--;
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // type 3 are op just leave them i guess 

        // for each first find the once that ae 

        DSU alice = new DSU(n+1); 
        DSU bob = new DSU(n+1); 
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            if (type == 3) {
                if(alice.find(u) == alice.find(v) && bob.find(u) == bob.find(v)){
                    count++; 
                }else{
                bob.union(u,v);
                alice.union(u,v); 
                }

            }
        }

        

        for (int e[] : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];
            if (type == 1) {
                if(alice.find(u) != alice.find(v)){
                    alice.union(u,v); 
                }else{
                    count++; 
                }
            }
            else if(type == 2){
                if(bob.find(u) != bob.find(v)){
                    bob.union(u,v); 
                }else{
                    count++; 
                }
            } 
        }

        if (alice.count == 2 &&  bob.count == 2)
            return count;
        return -1;
    }
}