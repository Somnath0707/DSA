public class DSU {
    private final int[] parent, rank;
    public int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry)
            return false;
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
        components--;
        return true;
    }
}

class Solution {

    public boolean check(int n, int val, int edges[][], int k) {
        DSU dsu = new DSU(n);
        for (int i = val+1; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            dsu.union(u, v);
        }

        int total = dsu.components;
        if (total >= k)
            return true;
        return false;
    }

    public int minTime(int n, int[][] edges, int k) {
        // wait how about i sort the edges and then do like bs then build the graph that is to the left if that has total connected component >=3 we more the mid to more left 
        // that it its genius 

        // sort by time 

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        if(check(n , -1 , edges , k)){
            return 0 ; 
        }
        int left = 0;
        int right = edges.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(n, mid, edges, k)) {
                ans = edges[mid][2];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}