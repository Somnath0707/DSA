class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  
        //2,7,4,1,8,1]
        for(int stone : stones){
            maxHeap.offer(stone);
        } 
        //[1,1,2,7,8]
        while(maxHeap.size()>1){
            int last = maxHeap.poll();
            int secLast = maxHeap.poll();
        ////[1,1,2]->8-7=1
            int diff = last - secLast;
            maxHeap.offer(diff);
            //[1,1,1,2]
        }

        if(maxHeap.size() == 0){
            return 0; 
        }else{
            return maxHeap.peek();
        }
    }
}