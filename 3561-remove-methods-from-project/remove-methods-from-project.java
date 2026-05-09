class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] nums) {
        Set<Integer> sus = new HashSet<>();
        Set<Integer> noSus = new HashSet<>();
        int len = nums.length ; 

        // the the dfs of the k and then put them in sus 

        // do the bfs if any one that go to the sus remove them from sus and add them to the no sus 
         HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] num : nums){
            int a = num[0];
            int b = num[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
        }
        // BFS from k
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        sus.add(k);

        while(!q.isEmpty()){
            int node = q.poll();
            if(graph.containsKey(node)){
                for(int nei : graph.get(node)){
                    if(!sus.contains(nei)){
                        sus.add(nei);
                        q.offer(nei);
                    }
                }
            }
        }


        for(int num[] : nums){
            int a = num[0];
            int b = num[1];
            if(!sus.contains(a) && sus.contains(b)){

            ArrayList<Integer> all = new ArrayList<>();

            for(int i = 0; i < n; i++){
                all.add(i);
            }

            return all;
}
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(!sus.contains(i)){
                list.add(i);
            }
        }

        return list ;

        


    }
}