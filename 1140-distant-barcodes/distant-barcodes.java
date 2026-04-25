class Solution {
    public int[] rearrangeBarcodes(int[] nums) {
        // First take the one with the hightest  count 
        // Then take the next with the second lowest count
        Map<Integer , Integer> map =new HashMap<>();
        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0 ) + 1 );
        } 

        PriorityQueue<int[]>  pq = new PriorityQueue<>((a,b ) -> {
            return b[0] - a[0];
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer( new int[]{entry.getValue() , entry.getKey()});
        }
        int ans[] = new int[nums.length];
        int i = 0 ; 
        while(pq.size() > 1){
            int[] curr = pq.poll();
            int count = curr[0];
            
            int num = curr[1];
            ans[i++] = num;

            int[] sec = pq.poll();
            int nextCount = sec[0];
            int nextNum = sec[1];
            ans[i++] = nextNum;
            if(count -1 > 0){
                int newCount = count -1 ; 
                pq.offer(new int[]{newCount , num});
            }
            if(nextCount -1 >0){
                int newCount = nextCount - 1;
                pq.offer(new int[]{newCount , nextNum});
            }
        }
        
        if(!pq.isEmpty()){
            int temp[] = pq.poll();

            ans[i++] = temp[1];
        }

        return ans ; 
    }
}