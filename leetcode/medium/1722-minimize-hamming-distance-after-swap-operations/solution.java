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
    public int minimumHammingDistance(int[] source, int[] target, int[][] edges) {
        //[5,1,2,4,3]-> 3 1 2 4 5 or [5,1,2,4,3
        //5,1,2,4,3-> 5 1 3 4 2 or 5,1,2,4,3
        // 3 1 2 4 5 -> 3 1 5 4 2 or  3 1 2 4 5
        // whenever there is a such interconneted swaping or dependence its alwaays turn out to be a graph question  so it becomes connected components so becoms union find 

        // 

        // so its the connected component I drew the image and the looks of it any value can travel to any where within that circuit 

        // the question is how to handle the dups like suppose two of the target want two same value so to whom should we give it or should we try both of them 

        // so i guess it doesnt matter to whom we give that dups the result irrespective would be same only 

        // so int each connected componented we try to match ask may values possible 
        // so how do we store like do we associtae the partent to a set or table to get the values from there 
        // suppose the 0 is the parent in the compontent we go throuhg the component and start giving the values they need and then remove that form the table 

        // count the total given - total correct suppose we are not able to give it a value we can consider it ahs given a ranodom vlue form the map that had not alreday been taken so we go for ward and in the end we know how many we got total correct right 
        int n = source.length ; 
        DSU dsu = new DSU(n); 
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            dsu.union(u , v);
        }

        Map<Integer,Map<Integer,Integer>> map = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            int val = source[i]; 
            int root = dsu.find(i); 

            map.putIfAbsent(root , new HashMap<>());
            map.get(root).put(val , map.get(root).getOrDefault(val , 0)+1);
        }
        int ans = 0 ; 

        for(int i = 0 ; i < n ; i++){
            int val = target[i]; 
            int root = dsu.find(i); 

            int count = map.get(root).getOrDefault(val ,0); 
            if(count == 0){
                // not found
                ans++; 
            }
            else{
                map.get(root).put(val , map.get(root).get(val)-1);
                if(map.get(root).get(val) == 0){
                    map.get(root).remove(val); 
                }
            }
        }
        return ans ; 
    }
}