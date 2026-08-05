class Encrypter {
    Map<Character  , String> map ; 
    Set<String> set ; 
    Map<String , List<Character>> temp ;
    Set<String> finalAns = new HashSet<>();  
    Map<String , Integer> dp ; 
    Map<String, Integer> cache;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map = new HashMap<>(); 
        set =new HashSet<>(); 
        temp = new HashMap<>(); 
        finalAns = new HashSet<>(); 
        cache = new HashMap<>(); 
        int n = keys.length; 
        for(int i = 0 ; i < n ; i++){
            map.put(keys[i] , values[i]);
            temp.putIfAbsent(values[i] , new ArrayList<>());
            temp.get(values[i]).add(keys[i]);
        }
        int m = dictionary.length; 
        for(int i = 0 ; i < m ; i++){
            String take = dictionary[i];
            finalAns.add(take);
            StringBuilder str = new StringBuilder(); 
            for(int j = 0 ; j < take.length(); j++){
                str.append(take.charAt(j));
                set.add(str.toString());
            }
        }
        
    }
    
    public String encrypt(String word1) {
        int n = word1.length() ; 
        StringBuilder str = new StringBuilder(); 
        
        for(int i = 0 ; i < n ; i++){
            
            char ch = word1.charAt(i); 
            if(!map.containsKey(ch)) return ""; 
            str.append(map.get(ch));
        }
        return str.toString(); 
    }
    
    public int decrypt(String word2) {
        int n = word2.length() ; 
        if(cache.containsKey(word2)) return cache.get(word2); 
        StringBuilder str = new StringBuilder() ; 
        //
        int result = f(0 , str , word2 , n ); 
        cache.put(word2 , result); 
        return result;
    }
    
    public int f(int i , StringBuilder str ,  String s , int n){
        if( i == n ){ 
            if(!finalAns.contains(str.toString())) return 0 ; 
            return 1; 
        }

        int take = 0 ; 

        String check = s.substring(i , i+2); 
        List<Character> list = temp.get(check); 
        if(list == null) return 0 ;  

        for(int ind = 0 ; ind < list.size() ; ind++){
            str.append(list.get(ind));
            if(set.contains(str.toString())){
                take += f(i+2 , str , s , n );
            }
            str.setLength(str.length()-1);
            
        }
        return take; 
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */