class Solution {
    public boolean isAns (Map<Character , Integer> check , Map<Character, Integer> map){

        for(char ch : map.keySet()){
            if(check.getOrDefault(ch , 0 ) < map.get(ch))
            return false ;
        }
    return true; 
    }
    public long validSubstringCount(String word1, String word2) {

        Map<Character, Integer> map = new HashMap<>();
        

        for(char c : word2.toCharArray()){
            map.put(c , map.getOrDefault(c , 0) + 1 ) ; 
        }

        Map<Character , Integer> check = new HashMap<>();

        long count = 0 ; 
        int i = 0 ;  
        boolean added = false;
        for(int j = 0; j < word1.length(); j++){
            char ch = word1.charAt(j);
            check.put(ch , check.getOrDefault(ch , 0 ) + 1);

            while(isAns(check , map)){
                count += word1.length() - j;

                char charI = word1.charAt(i);
                check.put(charI , check.get(charI) - 1);
                i++;
            }
        }

        return count ; 

    }
}