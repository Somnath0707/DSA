class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character , Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false; 
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0 ) +1); 
        }

        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)){
                return false; 
            }else{
                map.put(ch , map.get(ch)-1);
                if(map.get(ch) == 0) map.remove(ch); 
            }
        }
        return true; 
    }
}