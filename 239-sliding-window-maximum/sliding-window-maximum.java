class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int []> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i =0 ; i< k; i++){
            q.offer(new int[]{nums[i] , i});
        }

        List<Integer> list = new ArrayList<>();
        int n = nums.length ; 
        list.add(q.peek()[0]);
        for(int i = k ; i< n ; i++){
            q.offer(new int[]{nums[i] , i });

            while(q.peek()[1] <= i -k  ){
                q.poll();
            }

            list.add(q.peek()[0]);
        }
        int ans [] = new int[list.size()];

        for(int i = 0; i < list.size() ; i++){
            ans[i] = list.get(i);
        } 
        return ans ; 
        
    }
}