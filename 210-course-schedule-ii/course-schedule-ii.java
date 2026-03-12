class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a Adjcency list 
        List<List<Integer>> adj= new ArrayList<>();

        // make total number of the courses
        for(int i = 0; i< numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        // adj =
        //     0 -> []
        //     1 -> []
        //     2 -> []
        //     3 -> []
        //     4 -> []
        //     5 -> []

        for(int[] e : prerequisites){
            adj.get(e[1]).add(e[0]);
        }

        // 0 -> [1]
        // 1 -> [2,4]
        // 2 -> [3]
        // 3 -> [5]
        // 4 -> []
        // 5 -> []


        // create a indegree array to store number of incoming node 
        int indegree [] = new int[numCourses];

        //go thorugh the adj list and increase the indegree
        for(int i = 0 ; i < numCourses ; i++){
            for(int nei : adj.get(i)){
                indegree[nei]++;
            }
        }

        // Now we make a queue and add all the node with indegree 0 
        Queue<Integer> q = new LinkedList<>();

        for(int i= 0 ; i< indegree.length ; i++){
            if(indegree[i] == 0) q.add(i);
        }

        // Create a list to store all the topo sorted number 
        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0 ) q.add(nei);

            }
        }

        if(topo.size() != numCourses)
        return new int[]{};
        int ans[] = new int[topo.size()];
        for(int i = 0; i < topo.size(); i++){
            ans[i] = topo.get(i);
        }
        return ans;
    }
}