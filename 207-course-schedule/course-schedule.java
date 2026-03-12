class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e : prerequisites){
                adj.get(e[1]).add(e[0]);
        }

        int[] inOrder = new int[numCourses];

        for(int i = 0; i< adj.size() ; i++){
            for(int nei : adj.get(i)){
                inOrder[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< inOrder.length ; i++){
            if(inOrder[i] == 0 ) q.add(i);
        }


        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int i : adj.get(node)){
                inOrder[i]--;
                if(inOrder[i] == 0 ) q.add(i);
            }
        }


        if(topo.size() < numCourses) return false; 
        else return true ;
        
    }
}