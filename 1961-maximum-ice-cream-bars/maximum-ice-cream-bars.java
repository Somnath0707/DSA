class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int n : costs){
            pq.offer(n);
        }
        int count =0 ; 
        int temp = 0 ; 
        while(!pq.isEmpty()){
            temp+= pq.poll(); 
            if(temp <= coins) count++;
            else break;
        }
        return count ; 
    }
}