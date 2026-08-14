class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length(); 

        Map<Character,Integer> map = new HashMap<>(); 
        int i = 0 ; 
        int ans = 0 ; 
        for(int j = 0 ; j < n ; j++){
            char ch = s.charAt(j); 

            map.put(ch , map.getOrDefault(ch , 0)+1); 

            while(map.get(ch) > 2){
                char firstCh = s.charAt(i); 
                map.put(firstCh , map.get(firstCh)-1);
                if(map.get(firstCh) == 0 ){
                    map.remove(firstCh); 
                }
                // System.put.
                i++; 
            }

            ans = Math.max(ans , j-i+1); 
        }
        return ans; 
    }
}