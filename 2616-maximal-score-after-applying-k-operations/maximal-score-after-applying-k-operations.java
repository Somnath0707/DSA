class Solution {
    public long maxKelements(int[] nums, int k) {
        long count =0 ; 
        int kCount = k;
        long ans = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums){
            q.offer(n);
        }

        while(kCount>0){
            int val = q.poll();
            ans += val;
            int last = (val + 2) /3;
            q.offer(last);
            kCount--;
        }
        return ans ;
        
    }
}