class Solution {
    public int minGroups(int[][] intervals) {
        // we sort them 
        // check if they belong to the current range if yeah we pass them to the next stage 

        // if they do not over lap we put them in one stage only 

        //  [[5,10],[6,8],[1,5],[2,3],[1,10]] -> [1,10][1,5][2,3][5,10][6,8]

        // so first we take i 1,10 are that any that do not over lap no so in this range only 1,10 remain 

        // so for other [1,5][2,3][5,10][6,8] for 1,5 over lap are 2,3 and 5,10 and no over lap are 6,8 so remove the non overlap 1,5 and 6,8 remove 

        // now remoain are 2,3  5,10 they do not over lap so we remove them both so totral = 3 

        Arrays.sort(intervals , (a,b)-> {
            if(a[0] != b[0]) return a[0]-b[0];
            return b[1] - a[1]; 
        });

        // List<int[]> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int num[] : intervals){
            int start = num[0]; 
            int end = num[1] ; 

            

            if(!pq.isEmpty() && start > pq.peek()){
                // System.out.println(start +  " > " + pq.peek());
                // System.out.println("remove the one which is ending : " + pq.peek());
                pq.poll(); 
            }

            // System.out.println(" new end " + end);
            pq.offer(end);
            
        }
        return pq.size(); 
    }
}