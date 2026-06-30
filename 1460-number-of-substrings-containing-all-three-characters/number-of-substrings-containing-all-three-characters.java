class Solution {
    public int numberOfSubstrings(String s) {
        // aabbcc 
        // return 4;
        HashMap<Character , Integer> map = new HashMap<>(); 
        int count = 0 ; 
        int j = 0 ; 
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            while(map.size() <= 2 && j < n){
                char temp = s.charAt(j++);
                // System.out.println(temp);
                map.put(temp , map.getOrDefault( temp , 0) + 1 );
            }

            if(map.size() == 3){
                count += 1 + (n - j) ; 
            }

            map.put(ch , map.getOrDefault(ch , 0 ) - 1);
            // System.out.println("is removed : " + ch);
            if(map.get(ch) == 0) map.remove(ch);
        }

        return count ; 
    }
}