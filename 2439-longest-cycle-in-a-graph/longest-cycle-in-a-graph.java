class Solution {

    int n;

    boolean global[];

    public int bfs(int i, int[] edges) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int node = i;
        int dis = 0;
        while(node != -1){
            if(map.containsKey(node)){
                return dis - map.get(node);
            }
            if(global[node])
                return -1;
            global[node] = true;
            map.put(node, dis++);
            node = edges[node];
        }
        return -1;
    }

    public int longestCycle(int[] edges) {
        n = edges.length;
        global = new boolean[n];
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(!global[i]){
                ans = Math.max(ans,bfs(i, edges));
            }
        }
        return ans;
    }
}