class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        int indx = 0 ; 
        for(int row[] : grid){
            Arrays.sort(row);
            int limit = limits[indx++];
            int i = row.length - 1;
            while(limit !=0){
                if(pq.size() < k){
                    pq.offer(row[i--]);
                }
                else{
                    pq.offer(row[i--]);
                    pq.poll();
                }
                limit--;
            }
        } 
        long sum = 0 ; 
        while(!pq.isEmpty()){
            sum+= pq.poll();
        }
        return sum;
    }
}