class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char p : t.toCharArray()){
            map.put(p , map.getOrDefault( p , 0 ) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int startWin = 0;
        int uniqueChar = map.size();
        int endWin = 0; 
        int startIndex =-1 ; 
        int n = s.length();

        while( endWin < n){
            char ch = s.charAt(endWin);

            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)-1);
                if(map.get(ch) == 0) uniqueChar --;
            }

            while(uniqueChar == 0 ){
                int len = endWin - startWin + 1;
                if(minLen > len){
                    minLen = len ; 
                    startIndex = startWin; 
                }
                ch = s.charAt(startWin);
                if(map.containsKey(ch)){
                    map.put(ch , map.get(ch)+1);
                if(map.get(ch) > 0) uniqueChar ++;
                }
                startWin++;
            }
        endWin++;
        }
        if(startIndex == -1 ) return "";

        return s.substring(startIndex , startIndex + minLen);
    }
}