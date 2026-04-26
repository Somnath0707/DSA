class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b );

        for(int i = 0 ; i < nums.length ; i++){

            if(pq.size() == k){
                pq.offer(nums[i]);
                pq.poll();
                continue;
            }

            pq.offer(nums[i]);

        }
        return pq.poll();
    }
}