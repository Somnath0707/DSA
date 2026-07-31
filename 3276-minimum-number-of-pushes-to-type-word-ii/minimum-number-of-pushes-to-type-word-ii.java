class Solution {
    public int minimumPushes(String word) {
        // whichever reapaet the most give them 1 and go on like that 
        Map<Character,Integer> map = new HashMap<>(); 

        for(char ch : word.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) +1); 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            int key = entry.getKey(); 
            int val = entry.getValue(); 
            
            pq.offer(val);
            // System.out.println(pq.peek());
        }

        int count = 0 ; 
        int ans = 0 ; 
        int counter = 1; 
        while(!pq.isEmpty()){
            // System.out.println(pq.peek());
            int val = pq.poll() ; 
            ans += counter * val ; 
            count++; 
            if(count % 8 == 0){
                counter++;
            }
        }
        return ans; 
    }
}