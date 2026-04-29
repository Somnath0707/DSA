class Solution {
    public String largestMerge(String word1, String word2) {
        // abdcabcabcaba
        Map<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < 26 ; i++){
            char ch = (char)('a' + i);
            map.put(ch , i);
        }

        // Both words could be of any size 
        int i = 0 ; 
        int j = 0 ; 
        StringBuilder str = new StringBuilder();
        while(i < word1.length() && j < word2.length()){
            char s1 = word1.charAt(i);
            char s2 = word2.charAt(j);
            boolean wordF = false;
            boolean wordS = false ; 
            
            // If both the char are same
            if(map.get(s1) == map.get(s2)){
                int tempI = i;
                int tempJ = j ;
                while(map.get(tempI) == map.get(tempJ) && tempI< word1.length() && tempJ < word2.length()){
                    char tempS = word1.charAt(tempI);
                    char tempS2 = word2.charAt(tempJ);
                    if(map.get(tempS) == map.get(tempS2)){
                        tempI++;
                        tempJ++;
                    }
                    else if(map.get(tempS) > map.get(tempS2)){
                        wordF = true;
                        break;
                    }else{
                        wordS = true; 
                        break;
                    }
                }
            }


            // If char one is greater than char two 
            if(map.get(s1) > map.get(s2) || wordF == true){
                str.append(s1);
                i++;
                continue;
            }

            // if char two is greater than char one 
            if(map.get(s2) > map.get(s1) || wordS == true){
                str.append(s2);
                j++;
                continue;
            }


            // both of them are same till the end of life we just do 1 here 
            if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                str.append(s1);
                i++;
                continue;
            }else{
                str.append(s2);
                j++;
                continue;
            }
        }

        while(i < word1.length()){
            str.append(word1.charAt(i));
            i++;
        }

        while(j < word2.length()){
            str.append(word2.charAt(j));
            j++;
        }



        return str.toString();
    }
}