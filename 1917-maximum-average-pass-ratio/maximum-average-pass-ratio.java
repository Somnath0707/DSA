class Solution {
    public double maxAverageRatio(int[][] nums, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>( (a, b) -> Double.compare(b[0], a[0]));
        int n = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            double pass = nums[i][0];
            double total = nums[i][1];
            double avg = (double) (pass + 1)/ (total+1 )- (double)pass / total; 

            pq.offer(new double[]{avg , pass , total});
        }

        while(extraStudents != 0 ){
            double curr[] = pq.poll();
            double pass = curr[1];
            double avg = curr[0];
            double total = curr[2];

            pass ++; 
            total++;
            avg = (double)( pass + 1)/ (total+1 )- (double)pass / total; ; 
            extraStudents--;
            pq.offer(new double[]{avg , pass , total});
        }
        double ans = 0 ; 
        while(!pq.isEmpty()){
            double curr[] = pq.poll();
            ans += curr[1] / curr[2];
        }
        return ans / n ; 
    }
}

// 50 , 60 , 100
// 3/4 , 3/5 , 2/2
//