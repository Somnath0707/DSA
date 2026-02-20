class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> map = new HashSet<>();

        map.add('a');
        map.add('e');
        map.add('i');
        map.add('o');
        map.add('u');
        int count = 0; 
        int max =0 ; 
        int c = 0;
        for(int i = 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            if(map.contains(ch)){
                count++;
            }
            c++;
            if(c>k){
                if(map.contains(s.charAt(i-k))){
                    count--;
                }
            }
            max= Math.max(max ,count);
        }
        return max;
    }
}