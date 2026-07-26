class Solution {
    Map<Character, Integer> scoreChar;
    Map<Character,Integer> letterCount ;

    public int f(int i , String[] words){
        if(i == words.length){
            return 0 ; 
        }

        int take = 0 ; 
        int skip = 0 ; 

        skip = f(i+1 , words);

        if(canTake(words[i])){
            getLetters(words[i]);
            take = getScore(words[i]) + f(i+1 , words);
            putLetters(words[i]);
        }

        return Math.max(take , skip); 
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        letterCount = new HashMap<>() ; 
        scoreChar = new HashMap<>(); 

        for(char ch : letters){
            letterCount.put(ch , letterCount.getOrDefault(ch , 0 ) + 1 ) ; 
        }

        for(char i = 'a' ; i <= 'z'  ; i++){
            scoreChar.put(i , score[i-'a']);
        }

        return f(0 , words );
    }


    public boolean canTake(String str){
        Map<Character , Integer> map = new HashMap<>(); 
        for(char ch : str.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1 ); 
        }
        for(char ch : str.toCharArray()){
            if(!letterCount.containsKey(ch)) return false; 
            if(letterCount.get(ch ) < map.get(ch)) return false; 
        }
        return true; 
    }

    public int getScore(String str){
        int ans = 0 ; 

        for(char ch : str.toCharArray()){
            ans += scoreChar.get(ch); 
        }
        return ans ; 
    }

    public void getLetters(String word){
        for(char ch : word.toCharArray()){
            letterCount.put(ch , letterCount.get(ch) -1);
        }
    }

    public void putLetters(String word){
        for(char ch : word.toCharArray()){
            letterCount.put(ch , letterCount.getOrDefault(ch , 0) + 1 ); 
        }
    }
}