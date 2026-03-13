class Pair{
    String first ;
    int second;

    Pair(String _first , int _second){
        this.first= _first;
        this.second = _second;
    }
}


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a queue to store the current string and steps count ;
        Queue<Pair>  q = new LinkedList<>();
        q.add(new Pair(beginWord , 1 ));

        // set to keep track of the visited strings
        Set<String> set = new HashSet<>();
        for(int i =0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;

            q.remove();

            if(word.equals(endWord)) return steps;

            for(int i =0 ; i< word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char replacedCharArr[] = word.toCharArray();
                    replacedCharArr[i] = ch;

                    String tempCheckForCurrOpp = new String(replacedCharArr);
                    if(set.contains(tempCheckForCurrOpp)){
                        set.remove(tempCheckForCurrOpp);
                        q.add(new Pair(tempCheckForCurrOpp , steps +1 ));
                    }
                }
            }
        }

    return 0 ; 

    }
}