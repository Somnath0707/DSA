class Solution {
    
    public long validSubstringCount(String word1, String word2) {

        Map<Character, Integer> map = new HashMap<>();
        

        for(char c : word2.toCharArray()){
            map.put(c , map.getOrDefault(c , 0) + 1 ) ; 
        }

        Map<Character , Integer> check = new HashMap<>();

        int formed = 0;
        int required = map.size();

        long count = 0 ; 
        int i = 0 ;  
        boolean added = false;

        for(int j = 0; j < word1.length(); j++){
            char ch = word1.charAt(j);
            check.put(ch , check.getOrDefault(ch , 0 ) + 1);

            if(map.containsKey(ch) && check.get(ch).intValue() == map.get(ch).intValue()){
                formed++;
            }

            while(formed == required){
                count += word1.length() - j;

                char charI = word1.charAt(i);
                
                if(map.containsKey(charI) && check.get(charI).intValue() == map.get(charI).intValue()){
                    formed--;
                }

                check.put(charI , check.get(charI) - 1);
                i++;
            }
        }

        return count ; 

    }
}