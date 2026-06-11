class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(citations.length == 1){
            if(citations[0] > 0) return 1 ; 
            return 0; 
        }
        for(int n : citations ){
            pq.offer(n);
        }
        int h = 0 ; 
        while(!pq.isEmpty()){
            if(pq.peek() >= pq.size()){
                h +=1;
            }
            pq.poll();
        }
        return h ;
    }
}