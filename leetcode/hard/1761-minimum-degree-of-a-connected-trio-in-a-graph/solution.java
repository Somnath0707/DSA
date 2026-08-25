class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        // we can use 3 loop first get the fist node and make adjlist with set
        // for each node travese the set and check if that node is connteced to somone which is also directly connected to the first node if so check how many node are that nodes connected i mean check set.size() for each node and answer should be size.size()-2 to the answer add them to visited path or something or no need to ig mark them as we are doing incremental and we dont need the total we need just the lowest indegreee


        List<Set<Integer>> list = new ArrayList<>(); 
        for(int i = 0 ; i <= n ; i++){
            list.add(new HashSet<>()); 
        }
        for(int num[] : edges){
            int u = num[0]; 
            int v = num[1]; 

            list.get(u).add(v); 
            list.get(v).add(u); 
        }
        int ans = Integer.MAX_VALUE; 
        for(int i = 1 ; i <= n ; i++){

            for(int j : list.get(i)){
                if(j <= i) continue ;

                for(int k : list.get(j)){
                    if(list.get(i).contains(k)){
                        int first = list.get(i).size()-2; 
                        int second = list.get(j).size()-2; 
                        int third = list.get(k).size()-2; 

                        int trio = first + second + third; 

                        ans = Math.min(trio , ans); 
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return -1; 
        return ans; 

    }
}