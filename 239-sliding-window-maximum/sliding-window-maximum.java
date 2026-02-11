class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Create a priority Queue to store the element and the index for the window size

        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        // Put the value int queue till the window i.e the first window 
        for(int i =0 ; i< k ; i++){
            pq.offer(new int[]{nums[i] , i });
        }

        // Store the answer 
        ArrayList<Integer> list = new ArrayList<>();
        
        // Add the first max int the list 
        list.add(pq.peek()[0]);

        for(int i =k ; i< nums.length  ; i++){
            pq.offer(new int [] {nums[i] , i });


            // We remove the value from the list which are out of the window 
            while(pq.peek()[1] <= i-k){
                pq.poll();
            }
            list.add(pq.peek()[0]);
        }
        int ans [] = new int[list.size()];

        for(int i =0 ; i< list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans ; 
    }
}