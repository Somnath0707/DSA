class Solution {
    public long totalCost(int[] nums, int k, int c) {
        
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();

        int left = 0 ; 
        int right = nums.length - 1; 
        long sum = 0 ; 
        
        for(int i = 0 ; i < c && left <= right ; i++){
            pqLeft.offer(nums[left++]);
        }

        for(int i = 0 ; i < c && left <= right ; i++){
            pqRight.offer(nums[right--]);
        }


        while(k > 0){
            // either side is empty take the max value to compare them 
            int leftVal = (pqLeft.isEmpty() ? Integer.MAX_VALUE : pqLeft.peek());
            int rightVal = (pqRight.isEmpty() ? Integer.MAX_VALUE : pqRight.peek());

            if(leftVal <= rightVal){
                sum += pqLeft.poll();
                if(left <= right){
                    pqLeft.offer(nums[left++]);
                }
            }
            else{
                sum += pqRight.poll();
                if(left <= right){
                    pqRight.offer(nums[right--]);
                }
            }
            k--;
        }
        return sum ; 
    }
}