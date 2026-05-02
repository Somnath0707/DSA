class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> low = new HashSet<>();
        Set<Character> high = new HashSet<>();
        Set<Character> removed = new HashSet<>();

        for(char ch : word.toCharArray()){
            // After the uppercase occ so removefrom the set 
            if(Character.isLowerCase(ch) && high.contains(Character.toUpperCase(ch))){
                high.remove(Character.toUpperCase(ch));
                removed.add(Character.toUpperCase(ch));
            }
            //
            else if(Character.isUpperCase(ch) && low.contains(Character.toLowerCase(ch)) && !removed.contains(ch)){
                high.add(ch);
            }
            else if(Character.isUpperCase(ch) && !low.contains(Character.toLowerCase(ch)) && !removed.contains(ch)){
                removed.add(ch);
            }
            
            if(Character.isLowerCase(ch)){
                low.add(ch);
            }

        }

        return high.size();
    }
}