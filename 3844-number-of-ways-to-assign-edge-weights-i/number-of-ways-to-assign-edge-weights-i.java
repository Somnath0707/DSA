class Solution {
    public int MOD = 1000000007;

    long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
    public int dfs(int node , int parent , List<List<Integer>> list){
        int longest = 0 ; 

        for(int nei : list.get(node)){
            if(nei == parent) continue; 
            longest = Math.max(longest , dfs(nei , node , list));
        }

        return( 1 + longest) % MOD;
    }
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i <= edges.length+1 ; i++){
            list.add(new ArrayList<>());
        }

        for(int e[] : edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        int longest = dfs(1 , -1 , list);

        int ans = (int)power(2 , longest-2);

        return ans ; 
    }
}