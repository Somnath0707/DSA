class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] nums) {
        Set<Integer> sus = new HashSet<>(); 
        Set<Integer> noSus = new HashSet<>(); 

        HashMap<Integer , ArrayList<Integer>> graph = new HashMap<>(); 

        for(int i = 0 ; i < n ; i++){
            graph.put(i , new ArrayList<>());
        }

        for(int[]num : nums){
            int a = num[0]; 
            int b = num[1]; 

            graph.get(a).add(b);
        }
        
        Queue<Integer> q = new LinkedList<>(); 
        sus.add(k); 

        q.offer(k); 

        while(!q.isEmpty()){
            int temp = q.poll(); 
            for(int val : graph.get(temp)){
                if(!sus.contains(val)){
                    sus.add(val);
                    q.offer(val); 
                }
            }
        }

        /// we have got all the suspect 

        for(int num[] : nums){
            int a = num[0]; 
            int b = num[1]; 

            if(!sus.contains(a) && sus.contains(b)){
                List<Integer> list = new ArrayList<>(); 
                for(int i = 0 ; i < n ; i++){
                    list.add(i); 
                }
                return list; 
            }
        }

    

        
        


        ArrayList<Integer> ans = new ArrayList<>(); 

        for(int i = 0 ; i < n ; i++){
            if(!sus.contains(i)){
                ans.add(i); 
            }
        }


        return ans; 
    }
}