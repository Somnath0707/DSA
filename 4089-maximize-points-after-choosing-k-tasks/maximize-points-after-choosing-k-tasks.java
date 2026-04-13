class Solution {
    public long maxPoints(int[] nums, int[] arr, int k) {
        int n = nums.length ;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // For each element in both the array take the max of them if we take from the tech 1 reduce k else keep it same 

        long sum = 0 ; 

        for(int i = 0 ; i < n ; i++){
            if(nums[i] >= arr[i]){
                sum += nums[i];
                k--;
            }
            else{
                sum+= arr[i];
                long diff = arr[i] - nums[i];
                pq.offer(diff);
            }
        }

        while( k > 0 ){
            long temp = pq.poll();
            sum -= temp;
            k--;
        }
        return sum;
    }
}