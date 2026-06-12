class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length; 
        if(n == 1 && k % 2 != 0) return -1 ; 
        if(n==1 ) return nums[0]; 

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a );

        for(int i = 0 ; i < n && i < k-1 ; i++){
            pq.offer(nums[i]);
        }

        // 5 2 2 -> 4 7 ...

        if(k > n-1 ) {
            System.out.println("Output is generated here  1");
            return pq.peek(); 
        }


        if(!pq.isEmpty() && pq.peek() > nums[k] ) {
            System.out.println("Output is generated here 2");
            return pq.peek();
        } 
        System.out.println("Output is generated here 3");
        return nums[k];
    }
}