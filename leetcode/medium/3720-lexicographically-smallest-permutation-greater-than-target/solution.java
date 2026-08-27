class Solution {
    TreeMap<Character,Integer> map ; 
    public String f(int i , int prev , String s , String target){
        if( i == s.length() ) return null ; 
        char ch = target.charAt(i); 
        Character key = map.ceilingKey(ch);
        if(key == null) return null ; 

        if(key == ch){
            map.put(ch , map.get(ch)-1);
            if(map.get(ch) == 0) map.remove(ch); 
            String res = 
            f(i+1 , i , s , target); 
            if(res != null){
                return ch + res ; 
            }
            map.put(ch , map.getOrDefault(ch , 0)+1); 
            key = map.higherKey(ch);
            if(key == null) return null ; 
        }
        
        map.put(key , map.get(key)-1);
        if(map.get(key) == 0) map.remove(key);
        StringBuilder str = new StringBuilder();
        str.append(key); 
        
        for (char k : map.keySet()) {
            int count = map.get(k);
            for (int j = 0; j < count; j++) {
                str.append(k);
            }
        }
        
        return str.toString();
    }
    public String lexGreaterPermutation(String s, String target) {
        map = new TreeMap<>(); 

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1); 
        }

        String ans =  f(0 , -1, s , target); 
        if(ans == null) return ""; 
        return ans; 


    }
}