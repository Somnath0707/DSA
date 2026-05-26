class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper= new HashSet<>();

        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch))
                upper.add(ch);
        }

        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch) && upper.contains(Character.toUpperCase(ch)) && !lower.contains(ch)){
                lower.add(ch);
            }
        }

        return lower.size();


    }
}