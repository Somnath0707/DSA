class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        // take the first letter of the sub and try to match it and from there check substring 
        // if it is found we got the answer 

        // or even simpler just for every  char check if there is something that maps to it if so we increase the length else we just restart search for subarray 
        int n = s.length();
        Map<Character , Set<Character>> map = new HashMap<>(); 

        for(int i = 0 ; i < mappings.length; i++){
            char val = mappings[i][0]; 
            char put = mappings[i][1]; 
            map.putIfAbsent(val , new HashSet<>());
            map.get(val).add(put);
        }
        int indx = 0 ; 
        for(int i = 0 ; i <= n-sub.length() ; i++){
            boolean matched = true; 
            for(int j = 0 ; j < sub.length(); j++){
                char ofS = s.charAt(i + j);
                char ofSub = sub.charAt(j);
                if(ofS == ofSub || (map.containsKey(ofSub) &&  map.get(ofSub).contains(ofS)))
                {
                    continue; 
                }
                else{
                    matched = false; 
                    break ; 
                }
            }
            if(matched ) return true; 
        }

    return false; 
    }
}