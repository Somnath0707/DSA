class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> q = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        q.offer(x);
        set.add(x);
        int cost = 0 ; 
        while(!q.isEmpty()){
            int size = q.size() ; 
            
            while(size-- >0 ){
                int curr = q.poll();    
                if(curr == y ) return cost ; 

                if(!set.contains(curr+1)){
                    q.offer(curr+1); 
                    set.add(curr+1);
                }
                if(!set.contains(curr-1) && curr -1 >= 0){
                    q.offer(curr-1);
                    set.add(curr-1);
                }
                if(curr % 11 == 0 && !set.contains(curr/11)){
                    q.offer(curr/11);
                    set.add(curr/11);
                }
                if(curr % 5 == 0  &&  !set.contains(curr/5)) {
                    q.offer(curr/5);
                    set.add(curr/5);
                }
            }
            cost++;
        }

        return -1; 
    }
}