class KthLargest {
    //create a min heap to store get the k th largest in data stream 
    PriorityQueue<Integer> minHeap; 
    // create a k var to get the value of k from the constructor 
    int k ; 

    public KthLargest(int k, int[] nums) {
        this.k = k ; 
        // initilize the minheap 
        minHeap = new PriorityQueue<Integer>();
        // put the value in heap until k
        for(int num : nums){
            minHeap.offer(num);

            // if heap become more than k poll 

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        
    }
    
    public int add(int val) {
        // place the new val from stream if there is place in the heap of size k 
        if(minHeap.size()<k){
            minHeap.offer(val);
            return minHeap.peek();
        }

        //now that the size of heap of is k we add new no then rearrage and remove 
        minHeap.offer(val);
        minHeap.poll();
        return minHeap.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */