class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String>matchingwords = new ArrayList<>();

        for(String word:words)
        {
            if(getFrequencyPattern(word).equals(getFrequencyPattern(pattern)))
            {
                matchingwords.add(word);
            }
        }
        return matchingwords;

    } 
    public List<Integer>getFrequencyPattern(String word)
    {
        Map<Character, Integer>indexMap =new HashMap<>();

        List<Integer>pattern= new ArrayList<>();

        for(int i=0 ;i<word.length() ;i++)
        {
            char ch= word.charAt(i);

            indexMap.putIfAbsent(ch, indexMap.size());
            pattern.add(indexMap.get(ch));
        }

        return pattern;
    }  
    
}