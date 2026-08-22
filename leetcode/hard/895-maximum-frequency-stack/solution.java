class FreqStack {
    // we wnat the most frequent element ok so pq 
    // we can do is use pq to map val , the pos and the last pos it appeared that means the latest 
    // if it is removed we get the latest pos from a map whcha has val treeset of all the index it appeared 

    // so we can sort the pq based on freq and if tie then based on the latest appear  but then again adding the we can dynamically change the value in the pq so we need to do is create a new HashMap every single pop operation or do like lazy delettion type shi 
    PriorityQueue<int[]> pq ; 
    Map<Integer,Integer> freq ; 
    Map<Integer,TreeSet<Integer>> valToInd ; 
    int ind  ; 
    public FreqStack() {
        pq = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return Integer.compare(b[1] , a[1]);
            else return Integer.compare(b[2] , a[2]);
        });
        ind = 0 ; 
        freq = new HashMap<>(); 
        valToInd = new HashMap<>(); 
    }
    
    public void push(int val) {
        int currFreq = freq.getOrDefault(val , 0); 

        ind++ ; 
        freq.put(val , freq.getOrDefault(val , 0)+1); 
        valToInd.putIfAbsent(val , new TreeSet<>());
        valToInd.get(val).add(ind);
        currFreq = freq.get(val); 
        int lastInd = valToInd.get(val).last(); 
        pq.offer(new int[]{val , currFreq , lastInd});
    }
    
    public int pop() {
        int curr[] = pq.poll(); 
        freq.put(curr[0] , freq.get(curr[0])-1);
        return curr[0]; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */