class Solution {
    public int mirrorFrequency(String s) {
        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        int total = 0 ; 

        for(char c = 'a' ; c<= 'm' ; c++){
            char m = (char)('z' - (c - 'a'));

            int freqC = map.getOrDefault(c , 0);
            int freqM = map.getOrDefault(m ,  0);

            if(map.containsKey(c) || map.containsKey(m)){
                total += Math.abs(freqC - freqM);
            }
        }


        for(char c = '0' ; c <= '4' ; c++){

            char m =  (char)('9' - (c -'0'));
            int freqC = map.getOrDefault(c , 0);
            int freqM = map.getOrDefault(m ,  0);

            if(map.containsKey(c) || map.containsKey(m)){
                total += Math.abs(freqC - freqM);
            }
        }
    return total;
    }
}