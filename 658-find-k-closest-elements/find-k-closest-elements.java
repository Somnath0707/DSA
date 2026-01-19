class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];  // larger dist first
            return b[1] - a[1];                    // tie-break: larger value first
        });

        for(int a : arr){
            int dist = Math.abs(a - x);
            maxHeap.offer(new int[]{dist,a});

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            list.add(maxHeap.poll()[1]);
        }
        Collections.sort(list);
        return list ; 
    }
}