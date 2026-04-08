class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0 ) + 1 ) ; 
        }

        int max = 0 ; 
        // handle the one case 
        if(map.containsKey(1)){
            int freq = map.get(1);
            if(freq % 2 == 0) freq--;   // make it odd
            max = freq;
        }

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int count = 0; 

            long n = key;
            if(key == 1 ) continue;

            while(map.containsKey((int)n)){
                int freq = map.get((int)n);

                if(freq >= 2){
                    count += 2 ; 
                }
                else{
                    count++;
                    break;
                }

                if( n > 1e9) break;
                n  = n * n ;
            }
            if(count % 2 == 0 ) count--; 
            max = Math.max(count, max);
        }
        return max; 
    }
}