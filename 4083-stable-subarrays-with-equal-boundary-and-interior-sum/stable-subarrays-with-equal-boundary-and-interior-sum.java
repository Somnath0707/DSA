class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long prefix[] = new long[n]; 

        prefix[0] = capacity[0]; 

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + capacity[i];
        }


        // Map<Integer,List<Integer>> map = new HashMap<>(); 
        // Set<String> set = new HashSet<>(); 

        // for(int i = 0 ; i < n ; i++){
        //     int num = capacity[i]; 
        //     map.putIfAbsent(num, new ArrayList<>());
        //     map.get(num).add(i);
        // }
        long count = 0 ; 
        Map<String,Integer> map = new HashMap<>();

        // 9 12 15 18 27
        for(int i = 2 ; i < n ; i++){

            long pastVal = capacity[i-2]; 
            long pastPrefix = prefix[i-2]; 

            String key = pastVal + "#" +  pastPrefix; 

            map.put(key , map.getOrDefault(key , 0) + 1 ) ; 


            long val = capacity[i]; 
            long target = prefix[i-1]-val;

            String real = val + "#" + target; 

            if(map.containsKey(real)) count+= map.get(real);


            // for(int j : map.get(val)){
            //     String key = j + "#" + i; 
            //     String temp = i + "#" + j ; 

            //     if(set.contains(key) || set.contains(temp)) continue; 
            //     set.add(key);
            //     set.add(temp);
            //     if(j-i+1 >=3){
            //         if(prefix[j-1] - prefix[i] == val) count++; 
            //     }
            // }
        }

        return count; 
    }
}