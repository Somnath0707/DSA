class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder str = new StringBuilder() ;

        for(String st : chunks){
            str.append(st);
        }

        int n = str.length() ; 
        StringBuilder newWord = new StringBuilder(); 
        Set<Character> set = new HashSet<>();
        Map<String , Integer> map = new HashMap<>();

        for(char i ='a' ; i <='z' ; i++){
            set.add(i);
        }

        for(int i = 0 ; i < n ; i++ ){
            char ch = str.charAt(i);

            if(set.contains(ch)){
                newWord.append(ch);
                // System.out.print(newWord + " ") ;
            }

            else if(ch =='-'){

                if(i> 0 && i < n-1 && str.charAt(i-1) != '-' && str.charAt(i+1) != '-' && str.charAt(i+1) != ' ' && str.charAt(i-1) != ' '){
                    newWord.append(ch);
                    // System.out.print(newWord);
                }
                else{
                    map.put(newWord.toString() , map.getOrDefault(newWord.toString() , 0 ) + 1 );
                    // System.out.println (newWord.toString());
                    newWord = new StringBuilder() ; 
                }
            }
            else{
                map.put(newWord.toString() , map.getOrDefault(newWord.toString() , 0 ) + 1 );
                // System.out.println(newWord.toString());
                newWord = new StringBuilder() ; 
            }
        }
        map.put(newWord.toString() , map.getOrDefault(newWord.toString() , 0 ) + 1 );
        // System.out.println(newWord.toString());
        newWord = new StringBuilder() ; 

        
        List<Integer> list = new ArrayList<> () ; 
        for(int i = 0 ; i < queries.length ; i++){
            list.add(map.getOrDefault(queries[i] , 0 ));
        }
        int ans[] = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans; 
    }
}