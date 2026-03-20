class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length ;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0 ; 
        int l = 0 ; 
        
        long days = 1 ; 
        for(int j = n-1 ; j >= 0 ; j--){
            for(int i = 0 ; i < m ; i++){
                pq.offer(values[i][j]);
            }
        }

        while(!pq.isEmpty()){
            ans += days * pq.poll();
            days++;
        }
        return ans ; 
    }
}